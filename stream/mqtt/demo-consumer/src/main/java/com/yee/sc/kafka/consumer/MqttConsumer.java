package com.yee.sc.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MqttConsumer {

    public static void main(String[] args) {
        SpringApplication.run(MqttConsumer.class, args);
    }

}
