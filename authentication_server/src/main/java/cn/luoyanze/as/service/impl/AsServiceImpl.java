package cn.luoyanze.as.service.impl;

import cn.luoyanze.as.mapper.SessionMapper;
import cn.luoyanze.as.pojo.*;
import cn.luoyanze.as.pojo.vo.TicketClient;
import cn.luoyanze.as.pojo.vo.TicketTgs;
import cn.luoyanze.as.service.AsService;
import cn.luoyanze.as.mapper.UserMapper;
import cn.luoyanze.as.utils.DesUtils;
import cn.luoyanze.as.utils.RsaUtils;
import com.alibaba.fastjson.JSON;
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
    private final SessionMapper sessionMapper;
    private final ServerKeyParent serverKey;

    public AsServiceImpl(UserMapper userMapper, SessionMapper sessionMapper, ServerKeyParent serverKey) {
        this.userMapper = userMapper;
        this.sessionMapper = sessionMapper;
        this.serverKey = serverKey;
    }

    @Override
    public String loginCheck(String sessionId, String id, String pwd, String desKey) {
        SessionPO sessionPO = sessionMapper.getSession(sessionId);
        id = RsaUtils.decrypt(id, sessionPO.getRsaPrivateKey());
        desKey = RsaUtils.decrypt(desKey, sessionPO.getRsaPrivateKey());
        sessionPO.setDesKeyClientTgs(desKey);

        Map<String, Object> res = checkStatus(id, pwd, desKey, sessionPO);
        sessionMapper.updateSession(sessionPO);
        return JSON.toJSONString(res);
    }

    private Map<String, Object> checkStatus(String id, String pwd, String desKey, SessionPO sessionPO) {
        UserPO user = userMapper.getClientUser(id);

        Map<String, Object> res = new HashMap<>();
        TicketClient ticketClient = new TicketClient();
        TicketTgs ticketTgs = new TicketTgs();

        res.put("ticketClientTgs", ticketClient);
        res.put("ticketTgsClient", ticketTgs);

        if (user == null) {//NO_USR_EXISTS
            ticketClient.setLoginStatus(DesUtils.encrypt(NO_USER_EXISTS, desKey));
        } else {
            pwd = RsaUtils.decrypt(pwd, sessionPO.getRsaPrivateKey());
            if (!user.getPassword().equals(pwd)) {//PASSWORD_ERROR
                ticketClient.setLoginStatus(DesUtils.encrypt(ERROR_PASSWORD, desKey));
            } else { //SUCCESS
                String keyCT = DesUtils.createKey();
                ticketClient.setKey(DesUtils.encrypt(keyCT, desKey));
                ticketClient.setLoginStatus(DesUtils.encrypt(SUCCESS, desKey));

                sessionPO.setClientId(id);
                sessionPO.setTimeStamp(String.valueOf(System.currentTimeMillis()));
                ticketTgs.setWithCode(keyCT, id, serverKey.getKeyTgs());
            }
        }
        return res;
    }

    @Override
    public String initStatus(String pubKey, String priKey, String sessionUUID) {
        sessionMapper.insert(sessionUUID, priKey, pubKey, "", "");
        Map<String, String> res = new HashMap<>();
        res.put("sessionId", sessionUUID);
        res.put("rsaPubKey", pubKey);
        return JSON.toJSONString(res);
    }

    @Override
    public String registerCheck(String sessionUUID, String clientId, String password, String desKey) {
        SessionPO sessionPO = sessionMapper.getSession(sessionUUID);
        clientId = RsaUtils.decrypt(clientId, sessionPO.getRsaPrivateKey());
        desKey = RsaUtils.decrypt(desKey, sessionPO.getRsaPrivateKey());

        Map<String, String> res = new HashMap<>();
        if (userMapper.getClientUser(clientId) == null) {//USER_EXISTS
            res.put("registerStatus", DesUtils.encrypt(FAILED, desKey));
        } else {// SUCCESS
            res.put("registerStatus", DesUtils.encrypt(SUCCESS, desKey));
            password = RsaUtils.decrypt(password, sessionPO.getRsaPrivateKey());
            userMapper.setClientUser(clientId, password);
        }

        return JSON.toJSONString(res);
    }

}
