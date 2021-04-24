package cn.luoyanze.as.pojo;

import cn.luoyanze.as.utils.RsaUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 9:55 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Deprecated
public class SessionKeys {
    private String privateKeyAs;
    private String publicKeyAs;
    private String desKey;

    public SessionKeys(String desKey, RsaUtils.Key keys) {
        this.desKey = desKey;
        this.privateKeyAs = keys.getPrivateKey();
        this.publicKeyAs = keys.getPublicKey();
    }
}
