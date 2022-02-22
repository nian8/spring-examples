package com.yee.sc.rabbit.consumer.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Demo04InputBinder {

    String BINDING_NAME = "demo-04-input";

    @Input(BINDING_NAME)
    SubscribableChannel getChannel();

}
