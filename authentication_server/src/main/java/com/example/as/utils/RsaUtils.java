package com.example.as.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.alibaba.fastjson.JSON;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 5:39 下午
 */


public class RsaUtils {

    public static String encrypt(String msg, String publicKey) {
        RSA rsa = new RSA(null, publicKey);
        return rsa.encryptStr(msg, KeyType.PublicKey);
    }

    public static String encrypt(Object o, String publicKey) {
        return encrypt(JSON.toJSONString(o), publicKey);
    }

    public static String decrypt(String msg, String privateKey) {
        RSA rsa = new RSA(privateKey, null);
        return rsa.decryptStr(msg, KeyType.PrivateKey);
    }

    public static String decrypt(Object o, String privateKey) {
        return encrypt(JSON.toJSONString(o), privateKey);
    }

}
