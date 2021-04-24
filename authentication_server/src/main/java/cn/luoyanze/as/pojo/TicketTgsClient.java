package cn.luoyanze.as.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 5:38 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTgsClient {
    private String sessionKeyClientTgs;
    private String clientId;
    private String loginTimeStamp;
}
