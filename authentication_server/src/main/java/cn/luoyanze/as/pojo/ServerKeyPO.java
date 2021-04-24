package cn.luoyanze.as.pojo;

import cn.luoyanze.as.mapper.ServerKeyMapper;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 6:16 下午
 *
 *  * save server key.
 *  * length = 32
 */

@Repository
@Data
public class ServerKeyPO {
    public  String keyServer;
    public  String keyAs;
    public  String keyTgs;

    private final ServerKeyMapper serverKeyMapper;

    public ServerKeyPO(ServerKeyMapper serverKeyMapper) {
        this.serverKeyMapper = serverKeyMapper;
        ServerKeyPO serverKey = serverKeyMapper.getServerKey();
        this.keyServer = serverKey.getKeyServer();
        this.keyAs = serverKey.getKeyAs();
        this.keyTgs = serverKey.getKeyTgs();
    }
}
