package cn.luoyanze.as.utils;


import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 5:39 下午
 */


public class RsaUtils {

    @Data
    public static class Key {
        private String publicKey;
        private String privateKey;

        public Key(String publicKey, String privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }
    }

    public static Key createRsaKey(){
        RSA rsa = new RSA();
        return new Key(rsa.getPublicKeyBase64(), rsa.getPrivateKeyBase64());
    }

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
