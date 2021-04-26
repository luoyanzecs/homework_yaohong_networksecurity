package cn.luoyanze.web.controller;

import cn.luoyanze.utils.DesUtils;
import cn.luoyanze.web.mapper.MessageMapper;
import cn.luoyanze.web.mapper.SessionMapper;
import cn.luoyanze.web.pojo.ServerKey;
import cn.luoyanze.web.pojo.SessionPO;
import cn.luoyanze.web.pojo.vo.Message;
import cn.luoyanze.web.pojo.vo.TicketTemp;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/26 2:06 下午
 */


@RestController
@RequestMapping("/api/server")
public class ServerController {

    private final ServerKey serverKey;
    private final SessionMapper sessionMapper;
    private final HttpServletResponse response;
    private final MessageMapper messageMapper;

    public ServerController(ServerKey serverKey, SessionMapper sessionMapper, HttpServletResponse response, MessageMapper messageMapper) {
        this.serverKey = serverKey;
        this.sessionMapper = sessionMapper;
        this.response = response;
        this.messageMapper = messageMapper;
    }


    @ResponseBody
    @PostMapping("/{sessionId}/{authenticator}/{clientId}")
    public String leaveMessage(@PathVariable("sessionId") String sessionId,
                               @PathVariable("clientId") String clientId,
                               @PathVariable("authenticator") String authenticator,
                               @RequestParam("ticket") TicketTemp ticket,
                               @RequestParam("msg") Message msg) {

        //check failed
        if (!checkTicket(clientId, sessionId, authenticator, ticket)) return null;
        //check success
        messageMapper.insertMsg(DesUtils.decrypt(clientId, ticket.getKey()), msg.decryptWith(ticket.getKey()));
        return "OK";
    }

    @ResponseBody
    @PostMapping("/{sessionId}/{authenticator}/{clientId}")
    public List<Message> browseMessages(@PathVariable("sessionId") String sessionId,
                                        @PathVariable("clientId") String clientId,
                                        @PathVariable("authenticator") String authenticator,
                                        @RequestParam("ticket") TicketTemp ticket) {

        if (checkTicket(clientId, sessionId, authenticator, ticket)) return null;

        List<Message> messages = messageMapper.selectMsg(ticket.getClientId());
        messages.forEach(message -> message.encryptWith(ticket.getKey()));
        return messages;
    }

    private boolean checkTicket(String authenticator, String msg) {
        return msg.contains(authenticator);
    }

    private boolean checkTicket(String clientId, String sessionId, String authenticator, TicketTemp ticket) {
        if (!checkTicket(DesUtils.decrypt(authenticator, serverKey.getKeyServer()), ticket.getKey())) {
            //check failed
            response.setStatus(403);
            return false;
        }
        // check success
        ticket.decrypt(serverKey.getKeyServer());
        DesUtils.decrypt(clientId, ticket.getKey());
        SessionPO session = sessionMapper.getSession(sessionId);

        if (!session.getClientId().equals(ticket.getClientId()) || !session.getClientId().equals(clientId)) {
            response.setStatus(403);
            return false;
        }
        return true;
    }

}









