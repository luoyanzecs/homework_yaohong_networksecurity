package cn.luoyanze.tgs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/24 2:06 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionPO {
    private String sessionId;
    private String rsaPrivateKey;
    private String rsaPublicKey;
    private String clientId;
    private String desKeyClientTgs;
    private String desKeyClientServer;
    private String desKeyClient;
    private String timeStamp;
}
