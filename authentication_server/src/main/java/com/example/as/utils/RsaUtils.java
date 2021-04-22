package com.example.as.utils;


import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.alibaba.fastjson.JSON;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 5:39 下午
 */


public class RsaUtils {

    public static String encrypt(String msg, String publicKey) {
        return new RSA(null, publicKey).encryptStr(msg, KeyType.PublicKey);
    }

    public static String encrypt(Object o, String publicKey) {
        return encrypt(JSON.toJSONString(o), publicKey);
    }

    public static String decrypt(String msg, String privateKey) {
        return new RSA(privateKey, null).decryptStr(msg, KeyType.PrivateKey);
    }

    public static String decrypt(Object o, String privateKey) {
        return encrypt(JSON.toJSONString(o), privateKey);
    }

}
