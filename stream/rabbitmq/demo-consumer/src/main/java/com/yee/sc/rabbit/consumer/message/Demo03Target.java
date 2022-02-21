package com.yee.sc.rabbit.consumer.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Demo03Target {

    String DEMO_03_INPUT = "demo-03-input";

    @Input(DEMO_03_INPUT)
    SubscribableChannel getChannel();

}
