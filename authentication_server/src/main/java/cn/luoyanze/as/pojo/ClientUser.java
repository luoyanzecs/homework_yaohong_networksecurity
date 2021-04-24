package cn.luoyanze.as.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 5:55 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientUser {
    String id;
    String password;
}
