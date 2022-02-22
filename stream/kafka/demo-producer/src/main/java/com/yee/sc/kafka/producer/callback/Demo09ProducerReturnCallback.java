package com.yee.sc.kafka.producer.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Component;

//@Component
public class Demo09ProducerReturnCallback {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @ServiceActivator(inputChannel = "DEMO-TOPIC-09.errors")
    public void handleError(ErrorMessage errorMessage) {
        logger.error("[handleError][headers：{}]", errorMessage.getHeaders());
        logger.error("[handleError][payload：{}]", errorMessage.getPayload().getMessage());
        logger.error("[handleError][originalMessage：{}]", errorMessage.getOriginalMessage());
    }

}
