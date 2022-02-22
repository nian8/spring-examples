package com.yee.sc.kafka.producer;

import com.yee.sc.kafka.producer.binder.Demo01OutputBinder;
import com.yee.sc.kafka.producer.binder.Demo02OutputBinder;
import com.yee.sc.kafka.producer.binder.Demo03OutputBinder;
import com.yee.sc.kafka.producer.binder.Demo04OutputBinder;
import com.yee.sc.kafka.producer.binder.Demo05OutputBinder;
import com.yee.sc.kafka.producer.binder.Demo06OutputBinder;
import com.yee.sc.kafka.producer.binder.Demo07OutputBinder;
import com.yee.sc.kafka.producer.binder.Demo08OutputBinder;
import com.yee.sc.kafka.producer.binder.Demo09OutputBinder;
import com.yee.sc.kafka.producer.binder.Demo10OutputBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({
        Demo01OutputBinder.class, Demo02OutputBinder.class, Demo03OutputBinder.class,
        Demo04OutputBinder.class, Demo05OutputBinder.class, Demo06OutputBinder.class,
        Demo07OutputBinder.class, Demo08OutputBinder.class, Demo09OutputBinder.class,
        Demo10OutputBinder.class
})
public class KafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

}
