package com.yee.sc.rabbit.producer.binder;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Demo08OutputBinder {

    String BINDING_NAME = "demo-08-output";

    @Output(BINDING_NAME)
    MessageChannel getChannel();

}
