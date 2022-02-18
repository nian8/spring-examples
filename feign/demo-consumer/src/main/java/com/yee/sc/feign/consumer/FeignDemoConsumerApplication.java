package com.yee.sc.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignDemoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignDemoConsumerApplication.class, args);
    }

}
