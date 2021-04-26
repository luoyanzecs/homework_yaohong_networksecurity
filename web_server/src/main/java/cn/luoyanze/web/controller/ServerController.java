package cn.luoyanze.web.controller;

import cn.luoyanze.web.pojo.vo.TicketTemp;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/26 2:06 下午
 */


@RestController
@RequestMapping("/api/server")
public class ServerController {


    @ResponseBody
    @PostMapping("/{sessionId}/{authenticator}/{clientId}/{friendId}")
    public String addFriend(@PathVariable("sessionId") String sessionId,
                            @PathVariable("clientId") String clientId,
                            @PathVariable("friendId") String friendId,
                            @PathVariable("authenticator") String authenticator,
                            @RequestParam("ticket") TicketTemp ticket
                            ) {

    }

    @ResponseBody
    @PostMapping("/{sessionId}/{authenticator}/{clientId}")
    public List<Map<String, Object>> browseMessages(@PathVariable("sessionId") String sessionId,
                                                    @PathVariable("clientId") String clientId,
                                                    @PathVariable("authenticator") String authenticator,
                                                    @RequestParam("ticket") TicketTemp ticket
                                                    ) {

    }

    private boolean checkTicket(String authenticator, String msg) {
        return msg.contains(authenticator);
    }

}









