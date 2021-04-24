package cn.luoyanze.as.mapper.impl;

import cn.luoyanze.as.service.cache.CacheMapper;
import cn.luoyanze.as.mapper.SessionKeyDao;
import cn.luoyanze.as.pojo.SessionKeys;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 9:59 下午
 */

@Data
@Repository
public class SessionKeyDaoImpl implements SessionKeyDao {
    private final CacheMapper cache;

    public SessionKeyDaoImpl(CacheMapper cache) {
        this.cache = cache;
    }

    @Override
    public SessionKeys getObject(String sessionId) {
        return cache.getCache(sessionId, SessionKeys.class);
    }
    

    @Override
    public String getRsaPublicKeyAs(String sessionId) {
        return cache.getCache(sessionId, SessionKeys.class).getPublicKeyAs();
    }

    @Override
    public String getRsaPrivateKeyAs(String sessionId) {
        return cache.getCache(sessionId, SessionKeys.class).getPrivateKeyAs();
    }

    @Override
    public String getDesKey(String sessionId) {
        return cache.getCache(sessionId, SessionKeys.class).getDesKey();
    }

    @Override
    public void setKey(String sessionId, SessionKeys rsa) {
        cache.putCache(sessionId, JSON.toJSONString(rsa));
    }

    @Override
    public void removeKey(String sessionId) {
        cache.removeCache(sessionId);
    }

    @Override
    public boolean isSessionId(String sessionId) {
        return cache.isSessionId(sessionId);
    }

}
