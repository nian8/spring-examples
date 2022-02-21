package com.yee.sc.rabbit.consumer.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Demo01Target {

    String DEMO_01_INPUT = "demo-01-input";

    @Input(DEMO_01_INPUT)
    SubscribableChannel demo01Input();

}
