package com.example.as.utlis;

import cn.hutool.crypto.asymmetric.RSA;
import com.example.as.pojo.ClientUser;
import com.example.as.utils.RsaUtils;
import org.junit.jupiter.api.Test;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 10:44 下午
 */


public class RsaUtilsTest {

    @Test
    public void encryptTest() {
        RSA rsa = new RSA();
        String privateKeyBase64 = rsa.getPrivateKeyBase64();
        String publicKeyBase64 = rsa.getPublicKeyBase64();

        //JSONObject json1 = JSONUtil.createObj()
        //        .put("a", "value1")
        //        .put("b", "value2")
        //        .put("c", "value3");
        String nihao = RsaUtils.encrypt("this is a important msg", publicKeyBase64);
        System.out.println(nihao);
        String b = RsaUtils.decrypt(nihao, privateKeyBase64);
        System.out.println(b);
    }

    @Test
    public void encryptTestJson() {
        ClientUser clientUser = new ClientUser("123", "123");

        RSA rsa = new RSA();
        String privateKeyBase64 = rsa.getPrivateKeyBase64();
        String publicKeyBase64 = rsa.getPublicKeyBase64();
        String str = RsaUtils.encrypt(clientUser, publicKeyBase64);
        System.out.println(str);
        System.out.println(RsaUtils.decrypt(str, privateKeyBase64));
    }
}
