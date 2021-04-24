package cn.luoyanze.as.service;


import cn.luoyanze.as.pojo.SessionKeys;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/23 4:04 下午
 */

@Service
public interface AsService {

    String ERROR_PASSWORD = "0";
    String SUCCESS = "1";
    String NO_USER_EXISTS = "2";
    String FAILED = "0";

    /**
     * login success : 1,
     * login failed :
     *      no user exists : 2,
     *      error password : 0
     *
     */
    String loginCheck(String sessionUUID, String id, String pwd, String key);

    /**
     *
     * push the RsaKey to cache,
     * return a AS_RSA_PUBLIC_KEY to client.
     *
     * @param key:
     * @param sessionUUID:  client_uuid
     * @return: java.lang.String
     */
    String initStatus(SessionKeys key, String sessionUUID);

    /**
     * all of the information is encrypt with client key.
     *
     * @param sessionUUID:
     * @param clientId: client account number
     * @param password:
     * @return: java.lang.String
     */
    String registerCheck(String sessionUUID, String clientId, String password);
}
