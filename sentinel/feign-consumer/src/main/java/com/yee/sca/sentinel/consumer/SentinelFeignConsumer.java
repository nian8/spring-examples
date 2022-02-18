package com.yee.sca.sentinel.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SentinelFeignConsumer {

    public static void main(String[] args) {
        SpringApplication.run(SentinelFeignConsumer.class, args);
    }

}
