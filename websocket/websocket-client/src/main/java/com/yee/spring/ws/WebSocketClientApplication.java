package com.yee.spring.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WebSocketClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketClientApplication.class, args);
    }

}
