package com.yee.sc.kafka.consumer.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Demo10InputBinder {

    String BINDING_NAME = "demo-10-input";

    @Input(BINDING_NAME)
    SubscribableChannel getChannel();

}
