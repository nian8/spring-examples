package com.yee.sc.rabbit.consumer;

import com.yee.sc.rabbit.consumer.binder.Demo01InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo02InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo03InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo04InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo05InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo06InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo07InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo08InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo09InputBinder;
import com.yee.sc.rabbit.consumer.binder.Demo10InputBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({
        Demo01InputBinder.class, Demo02InputBinder.class, Demo03InputBinder.class,
        Demo04InputBinder.class, Demo05InputBinder.class, Demo06InputBinder.class,
        Demo07InputBinder.class, Demo08InputBinder.class, Demo09InputBinder.class,
        Demo10InputBinder.class
})
public class RabbitConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumerApplication.class, args);
    }

}
