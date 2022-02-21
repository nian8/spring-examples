package com.yee.sc.rabbit.consumer;

import com.yee.sc.rabbit.consumer.message.Demo01Target;
import com.yee.sc.rabbit.consumer.message.Demo02Target;
import com.yee.sc.rabbit.consumer.message.Demo03Target;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({Demo01Target.class, Demo02Target.class, Demo03Target.class})
public class RabbitConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumerApplication.class, args);
    }

}
