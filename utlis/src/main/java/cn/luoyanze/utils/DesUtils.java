package cn.luoyanze.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.alibaba.fastjson.JSON;

import java.util.Base64;
import java.util.Random;


/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 6:12 下午
 */


public class DesUtils {
    public static String createKey() {
        String res = new String(Base64.getEncoder().encode(SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded()));
        char[] chars = res.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+' || chars[i] == '/' || chars[i] == '=')
                chars[i] = random();
        }
        return new String(chars);
    }

    private static char random() {
        int res = 0;
        Random random = new Random();
        int x = random.nextInt(3);
        switch (x) {
            case 0 :
                res = (char)(random.nextInt(10) + 48);
                break;
            case 1 :
                res = (char)(random.nextInt(26) + 65);
                break;
            case 2 :
                res = (char)(random.nextInt(26) + 97);
                break;
        }

        return (char) res;
    }

    public static String encrypt(String msg, String key) {
        return new SymmetricCrypto(SymmetricAlgorithm.DESede, Base64.getDecoder().decode(key)).encryptHex(msg);
    }

    public static String encrypt(Object o, String key) {
        return encrypt(JSON.toJSONString(o), key);
    }

    public static String decrypt(String msg, String key) {
        return new SymmetricCrypto(SymmetricAlgorithm.DESede, Base64.getDecoder().decode(key)).decryptStr(msg);
    }

}
