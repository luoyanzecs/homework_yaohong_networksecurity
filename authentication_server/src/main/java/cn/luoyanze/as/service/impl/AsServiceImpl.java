package cn.luoyanze.as.service.impl;

import cn.luoyanze.as.service.cache.CacheMapper;
import cn.luoyanze.as.pojo.ServerKeyPO;
import cn.luoyanze.as.pojo.TicketTgsClient;
import cn.luoyanze.as.service.AsService;
import cn.luoyanze.as.utils.RsaUtils;
import com.alibaba.fastjson.JSON;
import cn.luoyanze.as.mapper.SessionKeyDao;
import cn.luoyanze.as.mapper.UserMapper;
import cn.luoyanze.as.pojo.ClientUser;
import cn.luoyanze.as.pojo.SessionKeys;
import cn.luoyanze.as.pojo.TicketClientTgs;
import cn.luoyanze.as.utils.DesUtils;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/23 5:29 下午
 */

@Data
@Service
public class AsServiceImpl implements AsService {

    private final UserMapper userMapper;
    private final SessionKeyDao sessionKeyDao;
    //private final CacheMapper cache;
    private final ServerKeyPO serverKey;

    public AsServiceImpl(ServerKeyPO serverKey, UserMapper userMapper, SessionKeyDao sessionKeyDao, CacheMapper cache) {
        this.serverKey = serverKey;
        this.userMapper = userMapper;
        this.sessionKeyDao = sessionKeyDao;
        //this.cache = cache;
    }

    @Override
    public String initStatus(SessionKeys key, String uuid) {
        sessionKeyDao.setKey(uuid, key);
        Map<String, String> map = new HashMap<>();
        map.put("sessionId", uuid);
        map.put("rsaPubKey", key.getPublicKeyAs());
        return JSON.toJSONString(map);
    }

    @Override
    public String loginCheck(String sessionId, String id, String pwd, String desKey) {
        SessionKeys keys = sessionKeyDao.getObject(sessionId);
        id = RsaUtils.decrypt(id, keys.getPrivateKeyAs());
        ClientUser clientUser = userMapper.getClientUser(id);

        TicketClientTgs ticketCT = new TicketClientTgs();
        TicketTgsClient ticketTC = new TicketTgsClient();

        Map<String, Object> res = new HashMap<>();
        res.put("ticketCT", ticketCT);
        res.put("ticketTC", ticketTC);

        if (clientUser == null) {//no user exists
            ticketCT.setLoginStatus(DesUtils.encrypt(NO_USER_EXISTS, desKey));
        } else {
            pwd = RsaUtils.decrypt(pwd, keys.getPrivateKeyAs());
            if (clientUser.getPassword().equals(pwd)) {//success
                writeTicket(id, desKey, ticketCT, ticketTC);
            } else {//pwd error
                ticketCT.setLoginStatus(DesUtils.encrypt(ERROR_PASSWORD, desKey));
            }
        }
        return JSON.toJSONString(res);
    }

    private void writeTicket(String id, String desKey, TicketClientTgs ticketCT, TicketTgsClient ticketTC) {
        ticketCT.setLoginStatus(DesUtils.encrypt(SUCCESS, desKey));

        String key = DesUtils.createKey();
        ticketCT.setSessionKeyClientTgs(DesUtils.encrypt(key, desKey));

        ticketTC.setSessionKeyClientTgs(DesUtils.encrypt(key, serverKey.getKeyTgs()));
        ticketTC.setClientId(DesUtils.encrypt(id, serverKey.getKeyTgs()));
        ticketTC.setLoginTimeStamp(DesUtils.encrypt(String.valueOf(System.currentTimeMillis()), serverKey.getKeyTgs()));
    }


    @Override
    public String registerCheck(String sessionUUID, String clientId, String password) {
        SessionKeys keys = sessionKeyDao.getObject(sessionUUID);
        clientId = RsaUtils.decrypt(clientId, keys.getPrivateKeyAs());
        ClientUser user = userMapper.getClientUser(clientId);

        Map<String, String> res = new HashMap<>();
        String registerStatus;
        if (user == null) {//success
            password = RsaUtils.decrypt(password, keys.getPrivateKeyAs());
            userMapper.setClientUser(clientId, password);
            registerStatus = SUCCESS;
        } else {//fail
            registerStatus = FAILED;
        }
        res.put("registerStatus", registerStatus);

        return JSON.toJSONString(res);
    }

}
