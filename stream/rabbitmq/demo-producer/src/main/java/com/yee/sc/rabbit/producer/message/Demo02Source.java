package com.yee.sc.rabbit.producer.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Demo02Source {

    String DEMO_02_OUTPUT = "demo-02-output";

    @Output(DEMO_02_OUTPUT)
    MessageChannel getChannel();

}
