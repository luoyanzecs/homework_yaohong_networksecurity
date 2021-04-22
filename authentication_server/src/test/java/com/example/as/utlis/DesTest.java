package com.example.as.utlis;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.as.utils.DesUtils;
import com.example.as.utils.RsaUtils;
import org.junit.jupiter.api.Test;

import java.security.PrivateKey;
import java.util.Arrays;


/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 6:22 下午
 */


public class DesTest {



    @Test
    public void testDes() {
        String content = "test中文";
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
        System.out.println(Arrays.toString(key));
        SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DESede, key);
        byte[] encrypt = des.encrypt(content);
        byte[] decrypt = des.decrypt(encrypt);
        String encryptHex = des.encryptHex(content);
        System.out.println(encryptHex);
        String decryptStr = des.decryptStr(encryptHex);
        System.out.println(decryptStr);
    }

    @Test
    public void testJson() {
        DesUtils myTest = new DesUtils();
        JSONObject json1 = JSONUtil.createObj()
                .put("a", "value1")
                .put("b", "value2")
                .put("c", "value3");
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
        String encrypt = myTest.encrypt(json1, key);
        System.out.println(encrypt);
    }

    @Test
    public void testDesString() {
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
        DesUtils myDesUtils = new DesUtils();
        String hello = myDesUtils.encrypt("hello", key);
        System.out.println(hello);
        String deHello = myDesUtils.decrypt(hello, key);
        System.out.println(deHello);
    }

    @Test
    public void testDesJson() {
        DesUtils myTest = new DesUtils();
        JSONObject json1 = JSONUtil.createObj()
                .put("a", "value1")
                .put("b", "value2")
                .put("c", "value3");
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
        String encrypt = myTest.encrypt(json1, key);
        System.out.println(encrypt);
        String decrypt = myTest.decrypt(encrypt, key);
        System.out.println(decrypt);
    }

    @Test
    public void rsaTest() {
        RSA rsa = new RSA();
        String privateKeyBase64 = rsa.getPrivateKeyBase64();
        String publicKeyBase64 = rsa.getPublicKeyBase64();

        JSONObject json1 = JSONUtil.createObj()
                .put("a", "value1")
                .put("b", "value2")
                .put("c", "value3");
        String nihao = RsaUtils.encrypt(json1, publicKeyBase64);
        System.out.println(nihao);
        String b = RsaUtils.decrypt(nihao, privateKeyBase64);
        System.out.println(b);

    }

}
