package cn.luoyanze.as.utlis;

import cn.luoyanze.utils.RsaUtils;
import cn.hutool.crypto.asymmetric.RSA;
import cn.luoyanze.as.pojo.UserPO;
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
        UserPO userPO = new UserPO("123", "123");

        RSA rsa = new RSA();
        String privateKeyBase64 = rsa.getPrivateKeyBase64();
        String publicKeyBase64 = rsa.getPublicKeyBase64();
        String str = RsaUtils.encrypt(userPO, publicKeyBase64);
        System.out.println(str);
        System.out.println(RsaUtils.decrypt(str, privateKeyBase64));
    }

    @Test
    public void rsaTest() {
        for (int i = 0; i < 100; i++) {
            RsaUtils.Key rsaKey = RsaUtils.createRsaKey();
            System.out.println(rsaKey.getPrivateKey().length());
            System.out.println(rsaKey.getPublicKey().length());
            System.out.println("------------");
        }
    }

    @Test void keytest() {
        String a = RsaUtils.encrypt("fDspkstUtcFkcOxPCBmu8oyiKpEanQgs", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJ/WhppnVe2BNv7ZlFCuIMGpmgQ4gGP495jXvR58sEpcdP3NlFPhQWYvG9fjjqRsVwI/Szr32Kuk67DWOZ2L2mSU72U7ZzIUC0FMxFnVBPnPn/qvi2iga2vjGH6nCnQvQI1X/x5Iqm/ki9ggK6RmTRFgiVu8rR4Kr4/trcjFTYJwIDAQAB");
        System.out.println(a.length());
    }
}
