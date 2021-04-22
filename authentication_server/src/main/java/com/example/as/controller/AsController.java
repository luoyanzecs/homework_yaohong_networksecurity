package com.example.as.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 7:39 下午
 */


@RestController
@RequestMapping("/as")
public class AsController {

    private HttpSession httpSession;

    public AsController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @GetMapping("/created")
    String asRsaPublicKey() {
        System.out.println(httpSession.getId());
        return "key";
    }

    @GetMapping("/hello")
    String hello() {
        System.out.println(httpSession.getId());
        return hello();
    }
}
