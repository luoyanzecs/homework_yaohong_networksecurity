package cn.luoyanze.web;

import cn.luoyanze.web.pojo.vo.Message;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class WebServerApplicationTests {

    @Test
    void contextLoads() {
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message("1", "1", "1"));
        messages.add(new Message("2", "2", "2"));
        messages.add(new Message("2", "2", "2"));
        messages.forEach(message -> {
            message.setCtx("2222");
        });

        System.out.println(messages);
    }

    @Test
    void stringTest() {
        Message message = new Message("1", "1", "1");
        System.out.println(message.encryptWith("SmKibj4qKpuzXRYfFlIxIFHjs65teqSr"));
    }


}
