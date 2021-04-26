package cn.luoyanze.tgs.pojo.vo;

import cn.luoyanze.tgs.utils.DesUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/25 9:04 下午
 */


@Data
@NoArgsConstructor
public class TicketServer {
    private String key;
    private String clientId;
    private String serverId;

    public TicketServer(String key, String clientId, String serverId, String serverKey) {
        this.key = DesUtils.encrypt(key, serverKey);
        this.clientId = DesUtils.encrypt(clientId, serverKey);
        this.serverId = DesUtils.encrypt(serverId, serverKey);
    }
}
