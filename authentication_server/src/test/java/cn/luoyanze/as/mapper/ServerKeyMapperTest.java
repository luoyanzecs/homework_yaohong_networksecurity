package cn.luoyanze.as.mapper;

import org.junit.jupiter.api.Test;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/24 4:45 下午
 */

public class ServerKeyMapperTest {

    private final ServerKeyMapper serverKeyMapper;


    public ServerKeyMapperTest(ServerKeyMapper serverKeyMapper) {
        this.serverKeyMapper = serverKeyMapper;
    }

    @Test
    public void getServerKey() {
        System.out.println(serverKeyMapper.getServerKey());
    }
}
