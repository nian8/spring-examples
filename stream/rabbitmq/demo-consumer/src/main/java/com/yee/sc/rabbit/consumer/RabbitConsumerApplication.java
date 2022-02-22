package com.yee.sc.rabbit.consumer;

import com.yee.sc.rabbit.consumer.binder.Demo01InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo02InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo03InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo04InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo05InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo06InputBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({
        Demo01InputBinder.class, Demo02InputBinder.class, Demo03InputBinder.class,
        Demo04InputBinder.class, Demo05InputBinder.class, Demo06InputBinder.class
})
public class RabbitConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumerApplication.class, args);
    }

}
