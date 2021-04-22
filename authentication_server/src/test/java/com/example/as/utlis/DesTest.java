package com.example.as.utlis;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.as.configure.ServerKey;
import com.example.as.utils.DesUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 6:22 下午
 */


public class DesTest {

    @Test
    public void testKeyLength() {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        StringBuilder str3 = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            char x1 = (char) (new Random().nextInt(92) + 33);
            char x2 = (char) (new Random().nextInt(92) + 33);
            char x3 = (char) (new Random().nextInt(92) + 33);
            str1.append(x1);
            str2.append(x2);
            str3.append(x3);
        }
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

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

}
