package com.yee.sc.feign.consumer;

import com.yee.sc.feign.consumer.config.DefaultFeignClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(defaultConfiguration = DefaultFeignClientConfiguration.class)
public class FeignDemoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignDemoConsumerApplication.class, args);
    }

}
