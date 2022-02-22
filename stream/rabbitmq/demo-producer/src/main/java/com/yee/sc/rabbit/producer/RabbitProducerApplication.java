package com.yee.sc.rabbit.producer;

import com.yee.sc.rabbit.producer.binder.Demo01OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo02OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo03OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo04OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo05OutputBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({
        Demo01OutputBinder.class, Demo02OutputBinder.class, Demo03OutputBinder.class,
        Demo04OutputBinder.class, Demo05OutputBinder.class
})
public class RabbitProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerApplication.class, args);
    }

}
