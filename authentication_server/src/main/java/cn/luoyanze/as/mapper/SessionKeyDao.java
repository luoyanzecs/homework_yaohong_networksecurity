package cn.luoyanze.as.mapper;

import cn.luoyanze.as.pojo.SessionKeys;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 9:56 下午
 */

@Deprecated
public interface SessionKeyDao {
    /**
     *
     * get user's RSA keys from cache
     *
     * @param sessionId:
     * @return: com.example.as.pojo.RsaKey
     */
    SessionKeys getObject(String sessionId);
    String getRsaPublicKeyAs(String sessionId);
    String getRsaPrivateKeyAs(String sessionId);
    String getDesKey(String sessionId);
    void setKey(String sessionId, SessionKeys keys);
    void removeKey(String sessionId);

    boolean isSessionId(String sessionId);

}
