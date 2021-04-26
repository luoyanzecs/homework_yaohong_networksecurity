package cn.luoyanze.as.controller;

import cn.luoyanze.as.aop.annotation.ControllerPointCut;
import cn.luoyanze.as.service.AsService;
import cn.luoyanze.utils.RsaUtils;
import cn.luoyanze.utils.UUIDUtils;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 7:39 下午
 */


@Data
@RestController
@RequestMapping("/api/as")
public class AsController {

    private final AsService asService;

    public AsController(AsService asService) {
        this.asService = asService;
    }

    /**
     *
     * return a json string contains sessionID , AS_RSA_PUBLIC_KEY
     */
    @GetMapping("")
    String connect() {
        RsaUtils.Key rsaKey = RsaUtils.createRsaKey();
        return asService.initStatus(rsaKey.getPublicKey(), rsaKey.getPrivateKey(), UUIDUtils.create());
    }

    /**
     *
     * param using rsa.
     * return status encrypt with des.
     */
    @ControllerPointCut
    @GetMapping("/login/{sessionId}/{clientId}/{clientPassword}/{clientDesKey}")
    String login(@PathVariable("sessionId") String sessionId,
                 @PathVariable("clientId") String clientId,
                 @PathVariable("clientPassword") String password,
                 @PathVariable("clientDesKey") String encryptKeyClient) {

        return asService.loginCheck(sessionId, clientId, password, encryptKeyClient);
    }

    /**
     * using rsa, return status
     */
    @ControllerPointCut
    @GetMapping("/register/{sessionId}/{clientId}/{clientPassword}/{clientDesKey}")
    String register(@PathVariable("clientId") String id,
                    @PathVariable("clientPassword") String password,
                    @PathVariable("sessionId") String sessionId,
                    @PathVariable("clientDesKey") String desKey) {

        return asService.registerCheck(sessionId, id, password, desKey);
    }
}



