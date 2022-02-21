package com.yee.sc.rabbit.producer.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Demo01Source {

    String DEMO_01_OUTPUT = "demo-01-output";

    @Output(DEMO_01_OUTPUT)
    MessageChannel getChannel();

}
