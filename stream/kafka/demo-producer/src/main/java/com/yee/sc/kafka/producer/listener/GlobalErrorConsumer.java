package com.yee.sc.kafka.producer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.context.IntegrationContextUtils;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Component;

@Component
public class GlobalErrorConsumer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 全局异常处理：通过订阅全局错误 Channel
     * errorChannel
     *
     * @param errorMessage
     */
    @StreamListener(IntegrationContextUtils.ERROR_CHANNEL_BEAN_NAME)
    public void handleError(ErrorMessage errorMessage) {
        logger.error("[global][HandleError][payload：{}]", errorMessage.getPayload().getMessage());
        logger.error("[global][HandleError][originalMessage：{}]", errorMessage.getOriginalMessage());
        logger.error("[global][HandleError][headers：{}]", errorMessage.getHeaders());
    }

}
