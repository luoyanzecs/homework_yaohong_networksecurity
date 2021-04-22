package com.example.as.utils;

import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.alibaba.fastjson.JSON;


/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 6:12 下午
 */


public class DesUtils {
    public String encrypt(String msg, byte[] key) {
        return new SymmetricCrypto(SymmetricAlgorithm.DESede, key).encryptHex(msg);
    }

    public String encrypt(Object o, byte[] key) {
        return encrypt(JSON.toJSONString(o), key);
    }

    public String decrypt(String msg, byte[] key) {
        return new SymmetricCrypto(SymmetricAlgorithm.DESede, key).decryptStr(msg);
    }

    public String decrypt(Object o, byte[] key) {
        return decrypt(JSON.toJSONString(o), key);
    }
}
