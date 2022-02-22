package com.yee.sc.kafka.consumer.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Demo03InputBinder {

    String BINDING_NAME = "demo-03-input";

    @Input(BINDING_NAME)
    SubscribableChannel getChannel();

}
