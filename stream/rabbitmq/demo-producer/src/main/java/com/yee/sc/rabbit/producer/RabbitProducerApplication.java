package com.yee.sc.rabbit.producer;

import com.yee.sc.rabbit.producer.message.Demo01Source;
import com.yee.sc.rabbit.producer.message.Demo02Source;
import com.yee.sc.rabbit.producer.message.Demo03Source;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({Demo01Source.class, Demo02Source.class, Demo03Source.class})
public class RabbitProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerApplication.class, args);
    }

}
