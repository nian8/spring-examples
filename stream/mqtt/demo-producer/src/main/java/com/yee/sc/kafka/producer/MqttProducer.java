package com.yee.sc.kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MqttProducer {

    public static void main(String[] args) {
        SpringApplication.run(MqttProducer.class, args);
    }

}
