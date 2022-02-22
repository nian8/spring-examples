package com.yee.sc.rabbit.producer.callback;

import com.yee.sc.rabbit.common.message.EchoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class Demo09ProducerConfirmCallback {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ServiceActivator(inputChannel = "demo-09-producer-confirm")
    public void onPublisherConfirm(Message<EchoMessage> message) {
        logger.info("[onPublisherConfirm][headers：{}]", message.getHeaders());
        logger.info("[onPublisherConfirm][payload：{}]", message.getPayload());
    }

}
