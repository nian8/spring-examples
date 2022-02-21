package com.yee.sc.rabbit.consumer.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Demo01Target {

    String BINDING_NAME = "demo-01-input";

    @Input(BINDING_NAME)
    SubscribableChannel getChannel();

}
