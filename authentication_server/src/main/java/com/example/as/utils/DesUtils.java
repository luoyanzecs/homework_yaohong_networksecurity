package com.example.as.utils;

import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.json.JSONObject;


/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 6:12 下午
 */


public class DesUtils {
    public String encrypt(String msg, byte[] key) {
        SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DESede, key);
        return des.encryptHex(msg);
    }

    public String encrypt(Object o, byte[] key) {
        JSONObject json1 = new JSONObject(o);
        String content = json1.toString();
        return encrypt(content, key);
    }

    public String decrypt(String msg, byte[] key) {
        SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DESede, key);
        return des.decryptStr(msg);
    }

    public String decrypt(Object o, byte[] key) {
        JSONObject json1 = new JSONObject(o);
        String content = json1.toString();
        return decrypt(content, key);
    }
}
