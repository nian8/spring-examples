package com.yee.sc.rabbit.producer.binder;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Demo03OutputBinder {

    String BINDING_NAME = "demo-03-output";

    @Output(BINDING_NAME)
    MessageChannel getChannel();

}
