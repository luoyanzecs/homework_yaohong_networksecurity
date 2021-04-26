package cn.luoyanze.as.utlis;

import cn.luoyanze.utils.DesUtils;
import cn.luoyanze.utils.RsaUtils;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Base64;


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
        //DesUtils myTest = new DesUtils();
        //JSONObject json1 = JSONUtil.createObj()
        //        .put("a", "value1")
        //        .put("b", "value2")
        //        .put("c", "value3");
        //byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
        //String encrypt = myTest.encrypt(json1, key);
        //System.out.println(encrypt);
    }

    @Test
    public void testDesString() {
        //byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
        //DesUtils myDesUtils = new DesUtils();
        //String hello = myDesUtils.encrypt("hello", key);
        //System.out.println(hello);
        //String deHello = myDesUtils.decrypt(hello, key);
        //System.out.println(deHello);
    }

    @Test
    public void testDesJson() {
        //DesUtils myTest = new DesUtils();
        //JSONObject json1 = JSONUtil.createObj()
        //        .put("a", "value1")
        //        .put("b", "value2")
        //        .put("c", "value3");
        //byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
        //String encrypt = myTest.encrypt(json1, key);
        //System.out.println(encrypt);
        //String decrypt = myTest.decrypt(encrypt, key);
        //System.out.println(decrypt);
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

    @Test
    public void generate() {
        byte[] encoded = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
        Base64.Encoder encoder = Base64.getEncoder();
        System.out.println(new String(encoder.encode(encoded)));
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(new String(encoder.encode(encoded)));
        System.out.println(decode.length);
        System.out.println(new String(encoded));
    }

    @Test
    public void generate2() {
        //String str = "aeofn3sa40dxksddfwq1s3s2s5d2d3fh";
        //byte[] decode = Base64.getDecoder().decode(str);
        //System.out.println(decode.length);
    }

    @Test
    public void generate3() {
        for (int i = 0; i < 100; i++) {
            System.out.println(DesUtils.createKey());
        }
    }

}
