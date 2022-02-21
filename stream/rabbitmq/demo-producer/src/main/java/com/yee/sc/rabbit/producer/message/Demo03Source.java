package com.yee.sc.rabbit.producer.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Demo03Source {

    String DEMO_03_OUTPUT = "demo-03-output";

    @Output(DEMO_03_OUTPUT)
    MessageChannel getChannel();

}
