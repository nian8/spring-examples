package com.yee.sc.rabbit.consumer.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Demo02Target {

    String DEMO_02_INPUT = "demo-02-input";

    @Input(DEMO_02_INPUT)
    SubscribableChannel getChannel();

}
