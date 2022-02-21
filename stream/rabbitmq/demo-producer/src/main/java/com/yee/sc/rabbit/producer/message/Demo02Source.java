package com.yee.sc.rabbit.producer.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Demo02Source {

    String DEMO_01_OUTPUT = "demo-02-output";

    @Output(DEMO_01_OUTPUT)
    MessageChannel demo02Output();

}
