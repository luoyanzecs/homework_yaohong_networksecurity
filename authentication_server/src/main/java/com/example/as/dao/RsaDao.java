package com.example.as.dao;

import com.example.as.pojo.ClientUser;
import com.example.as.pojo.RsaKey;
import org.springframework.stereotype.Repository;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 9:56 下午
 */

@Repository
public interface RsaDao {
    /**
     *
     * get user's RSA keys from cache
     *
     * @param userId:
     * @return: com.example.as.pojo.RsaKey
     */
    RsaKey getRsaKeyObject(String userId);
    String getRsaPublicKeyClient(String userId);
    String getRsaPublicKeyAs(String userId);
    String getRsaPrivateKeyAs(String userId);
    void setRsaKey(String userId, RsaKey rsa);
    void removeRsaKey(String userId);

}
