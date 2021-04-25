package cn.luoyanze.as.pojo;

import cn.luoyanze.as.mapper.ServerKeyMapper;
import org.springframework.stereotype.Component;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/25 1:26 下午
 */


@Component
public class ServerKey extends ServerKeyParent{

    public ServerKey(ServerKeyMapper serverKeyMapper) {
        ServerKeyParent serverKey = serverKeyMapper.getServerKey();
        this.keyTgs = serverKey.getKeyTgs();
        this.keyServer = serverKey.getKeyServer();
        this.keyAs = serverKey.getKeyAs();
    }
}
