package com.example.as.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 9:55 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RsaKey {
    private String publicKeyClient;
    private String privateKeyAs;
    private String publicKeyAs;
}
