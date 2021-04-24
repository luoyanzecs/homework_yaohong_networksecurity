package cn.luoyanze.as.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 5:36 下午
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketClientTgs {
    private String sessionKeyClientTgs;
    private String loginStatus;
}
