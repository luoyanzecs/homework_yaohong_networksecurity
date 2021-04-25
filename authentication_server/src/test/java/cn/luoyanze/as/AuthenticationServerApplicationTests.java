package cn.luoyanze.as;

import cn.luoyanze.as.mapper.ServerKeyMapper;
import cn.luoyanze.as.mapper.SessionMapper;
import cn.luoyanze.as.pojo.ServerKeyParent;
import cn.luoyanze.as.pojo.SessionPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class AuthenticationServerApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    ServerKeyMapper serverKeyMapper;

    @Autowired
    ServerKeyParent serverKey;

    @Autowired
    SessionMapper sessionMapper;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
        System.out.println(serverKey);
    }

    @Test
    void sessionMap() {
        //sessionMapper.insert("1", "2", "3", "", "");
        SessionPO sessionPO = new SessionPO();
        sessionPO.setSessionId("1");
        sessionPO.setRsaPrivateKey("1");
        sessionPO.setRsaPrivateKey("2");
        sessionMapper.updateSession(sessionPO);
    }

}
