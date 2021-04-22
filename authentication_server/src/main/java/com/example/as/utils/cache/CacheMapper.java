package com.example.as.utils.cache;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 10:03 下午
 *
 * a cache database
 *
 */
public class CacheMapper {
    private static ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    public static boolean putCache(String key, String value) {
        cache.put(key, value);
        return true;
    }

    public static String getCache(String key) {
        return cache.get(key);
    }

    public static <T> T getCache(String key, Class<T> clazz) {
        return JSON.parseObject(getCache(key), clazz);
    }

    public static void removeCache(String key) {
        cache.remove(key);
    }
}
