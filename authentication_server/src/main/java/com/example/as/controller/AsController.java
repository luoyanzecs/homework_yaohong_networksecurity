package com.example.as.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 7:39 下午
 */


@RestController
@RequestMapping("/as")
public class AsController {

    @GetMapping("/create")
    String asRsaPublicKey() {
        return null;
    }
}
