package com.yee.sc.rabbit.producer.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Demo02Source {

    String BINDING_NAME = "demo-02-output";

    @Output(BINDING_NAME)
    MessageChannel getChannel();

}