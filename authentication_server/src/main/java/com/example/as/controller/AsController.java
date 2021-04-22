package com.example.as.controller;

import com.example.as.dao.RsaDao;
import com.example.as.dao.UserDao;
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
    private RsaDao rsaDao;
    private UserDao userDao;

    public AsController(HttpSession httpSession, RsaDao rsaDao, UserDao userDao) {
        this.httpSession = httpSession;
        this.rsaDao = rsaDao;
        this.userDao = userDao;
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
