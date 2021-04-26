package cn.luoyanze.tgs.pojo;

import lombok.Data;


/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 6:16 下午
 *
 *  * save server key.
 *  * length = 32
 */

@Data
public class ServerKeyParent {
    public String keyServer;
    public String keyAs;
    public String keyTgs;
}






