package cn.luoyanze.as.service.cache;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 10:03 下午
 *
 * a cache database
 *
 */

@Service
@Deprecated
public class CacheMapper {
    private ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    public void putCache(String key, String value) {
        cache.put(key, value);
    }

    public String getCache(String key) {
        return cache.get(key);
    }

    public <T> T getCache(String key, Class<T> clazz) {
        return JSON.parseObject(getCache(key), clazz);
    }

    public void removeCache(String key) {
        cache.remove(key);
    }

    public boolean isSessionId(String sessionId) {
        return cache.contains(sessionId);
    }
}
