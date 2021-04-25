package cn.luoyanze.as.pojo.vo;

import cn.luoyanze.as.utils.DesUtils;
import lombok.Data;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/25 12:20 下午
 */


@Data
public class TicketTgs {
    private String key;
    private String clientId;
    private String timestamp;

    public void setWithCode(String key, String clientId, String timestamp, String encrypt) {
        this.key = DesUtils.encrypt(key, encrypt);
        this.clientId = DesUtils.encrypt(clientId, encrypt);
        this.timestamp = DesUtils.encrypt(timestamp, encrypt);
    }
}
