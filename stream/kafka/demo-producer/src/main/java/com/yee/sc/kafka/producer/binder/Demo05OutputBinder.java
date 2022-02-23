package com.yee.sc.kafka.producer.binder;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Demo05OutputBinder {

    String BINDING_NAME = "demo-05-output";

    @Output(BINDING_NAME)
    MessageChannel getChannel();

}
