package cn.luoyanze.tgs.pojo.vo;

import cn.luoyanze.tgs.utils.DesUtils;
import lombok.Data;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/25 9:22 下午
 */


@Data
public class TicketTemp {
    private String key;
    private String clientId;

    public void decrypt(String key) {
        this.key = DesUtils.decrypt(this.key, key);
        this.clientId = DesUtils.decrypt(this.clientId, key);
    }
}
