package com.yee.sc.kafka.producer.binder;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Demo07OutputBinder {

    String BINDING_NAME = "demo-07-output";

    @Output(BINDING_NAME)
    MessageChannel getChannel();

}
