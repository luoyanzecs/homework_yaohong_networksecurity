package com.example.as.dao.impl;

import com.alibaba.fastjson.JSON;
import com.example.as.dao.RsaDao;
import com.example.as.pojo.ClientUser;
import com.example.as.pojo.RsaKey;
import com.example.as.utils.cache.CacheMapper;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 9:59 下午
 */


public class RsaDaoImpl implements RsaDao {
    @Override
    public RsaKey getRsaKeyObject(String userId) {
        return CacheMapper.getCache(getKeyFiled(userId), RsaKey.class);
    }

    @Override
    public String getRsaPublicKeyClient(String userId) {
        return CacheMapper.getCache(getKeyFiled(userId), RsaKey.class).getPublicKeyClient();
    }

    @Override
    public String getRsaPublicKeyAs(String userId) {
        return CacheMapper.getCache(getKeyFiled(userId), RsaKey.class).getPublicKeyAs();
    }

    @Override
    public String getRsaPrivateKeyAs(String userId) {
        return CacheMapper.getCache(getKeyFiled(userId), RsaKey.class).getPrivateKeyAs();
    }

    @Override
    public void setRsaKey(String userId, RsaKey rsa) {
        CacheMapper.putCache(getKeyFiled(userId), JSON.toJSONString(rsa));
    }

    @Override
    public void removeRsaKey(String userId) {
        CacheMapper.removeCache(userId);
    }

    private String getKeyFiled(String userId) {
        return userId + "_rsa_keys";
    }

}
