package com.yee.sc.kafka.consumer.listener;

import com.yee.sc.kafka.consumer.binder.Demo10InputBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Demo10Consumer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * {@link org.springframework.cloud.stream.binder.ConsumerProperties}
     *
     * @param messages
     */
    @StreamListener(Demo10InputBinder.BINDING_NAME)
    public void onMessage(@Payload Message<List<byte[]>> messages) {
        logger.info("[onMessage][线程编号:{} 消息主题:{} 消息数量: {}]",
                Thread.currentThread().getId(),
                Demo10InputBinder.BINDING_NAME,
                messages.getPayload().size());
        for (byte[] message : messages.getPayload()) {
            logger.info("消息内容: {}", new String(message));
        }
    }

}
