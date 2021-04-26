package cn.luoyanze.utils;

import java.util.UUID;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/23 8:01 下午
 */


public class UUIDUtils {
    public static String create() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
