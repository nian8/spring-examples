package com.yee.sc.rabbit.consumer.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Demo02InputBinder {

    String BINDING_NAME = "demo-02-input";

    @Input(BINDING_NAME)
    SubscribableChannel getChannel();

}
