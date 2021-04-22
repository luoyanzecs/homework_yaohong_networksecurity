package com.example.as.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 8:19 下午
 */

@Configuration
public class CORSConfigure implements WebMvcConfigurer {
    //@Autowired
    //Config config;
    //
    //@Override
    //public void addCorsMappings(CorsRegistry registry) {
    //    registry.addMapping("/**")
    //            .allowedOrigins(config.getFrontUrl())
    //            .allowedMethods("*")
    //            .allowedHeaders("*")
    //            .allowCredentials(true);
    //}
}
