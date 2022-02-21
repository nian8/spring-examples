package com.yee.sc.rabbit.producer.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MySource {

    @Output("demo01-output")
    MessageChannel demo01Output();

}
