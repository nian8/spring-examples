package com.yee.sc.rabbit.consumer.listener;

import com.yee.sc.rabbit.consumer.message.Demo01Target;
import com.yee.sc.rabbit.consumer.message.EchoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Demo01Consumer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @StreamListener(Demo01Target.DEMO_01_INPUT)
    public void onMessage(@Payload EchoMessage message) {
        logger.info("[onMessage][线程编号:{} 消息标签: {} 消息内容: {}]",
                Thread.currentThread().getId(),
                "",
                message);
    }

}
