package com.yee.sc.kafka.consumer;

import com.yee.sc.kafka.consumer.binder.Demo01InputBinder;
import com.yee.sc.kafka.consumer.binder.Demo02InputBinder;
import com.yee.sc.kafka.consumer.binder.Demo03InputBinder;
import com.yee.sc.kafka.consumer.binder.Demo04InputBinder;
import com.yee.sc.kafka.consumer.binder.Demo05InputBinder;
import com.yee.sc.kafka.consumer.binder.Demo06InputBinder;
import com.yee.sc.kafka.consumer.binder.Demo07InputBinder;
import com.yee.sc.kafka.consumer.binder.Demo08InputBinder;
import com.yee.sc.kafka.consumer.binder.Demo10InputBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({
        Demo01InputBinder.class, Demo02InputBinder.class, Demo03InputBinder.class,
        Demo04InputBinder.class, Demo05InputBinder.class, Demo06InputBinder.class,
        Demo07InputBinder.class, Demo08InputBinder.class,
        Demo10InputBinder.class
})
public class KafkaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }

}
