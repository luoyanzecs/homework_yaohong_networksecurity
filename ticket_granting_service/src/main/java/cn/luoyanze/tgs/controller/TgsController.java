package cn.luoyanze.tgs.controller;

import cn.luoyanze.tgs.mapper.SessionMapper;
import cn.luoyanze.tgs.pojo.ServerKey;
import cn.luoyanze.tgs.pojo.SessionPO;
import cn.luoyanze.tgs.pojo.vo.TicketClient;
import cn.luoyanze.tgs.pojo.vo.TicketServer;
import cn.luoyanze.tgs.pojo.vo.TicketTemp;
import cn.luoyanze.utils.DesUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/25 9:00 下午
 */

@RestController
@RequestMapping("/api/tgs")
public class TgsController {

    private final ServerKey serverKey;
    private final SessionMapper sessionMapper;
    private final HttpServletResponse response;

    public TgsController(ServerKey serverKey, SessionMapper sessionMapper, HttpServletResponse response) {
        this.serverKey = serverKey;
        this.sessionMapper = sessionMapper;
        this.response = response;
    }

    @ResponseBody
    @PostMapping("/{sessionId}/{authenticator}/{serverPrincipal}")
    public Map<String, Object> connect(@PathVariable("sessionId") String sessionId,
                          @PathVariable("authenticator") String authenticator,
                          @PathVariable("serverPrincipal") String serverId,
                          @RequestParam("ticket") TicketTemp ticket) {

        SessionPO session = sessionMapper.getSession(sessionId);

        if (session == null ||
                checkTicket(DesUtils.decrypt(authenticator, session.getDesKeyClientTgs()),session.getDesKeyClientTgs())) {
            response.setStatus(403);
            return null;
        } else {
            ticket.decrypt(session.getDesKeyClientTgs());
            if (session.getClientId().equals(ticket.getClientId())) {
                response.setStatus(403);
                return null;
            } else {//SUCCESS return ticket
                Map<String, Object> res = new HashMap<>();
                String key = DesUtils.createKey();
                serverId = DesUtils.decrypt(serverId, session.getDesKeyClientTgs());
                res.put("ticketClientServer", new TicketClient(DesUtils.encrypt(key, session.getDesKeyClientTgs())));
                res.put("ticketServerClient", new TicketServer(key, session.getClientId(), serverId, serverKey.getKeyServer()));
                return res;
            }
        }
    }

    private boolean checkTicket(String authenticator, String msg) {
        return msg.contains(authenticator);
    }
}





