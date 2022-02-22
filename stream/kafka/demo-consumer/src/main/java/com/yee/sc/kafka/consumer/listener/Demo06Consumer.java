package com.yee.sc.kafka.consumer.listener;

import com.yee.sc.kafka.consumer.binder.Demo06InputBinder;
import com.yee.sc.kafka.common.message.EchoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Demo06Consumer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @StreamListener(value = Demo06InputBinder.BINDING_NAME,
            condition = "headers['tag'] == 'yunai'")
    public void onMessage(@Header(value = "tag") String tag,
                          @Payload EchoMessage message) {
        logger.info("[onMessage][线程编号:{} 消息主题:{} 消息标签: {} 消息内容: {}]",
                Thread.currentThread().getId(),
                Demo06InputBinder.BINDING_NAME,
                tag,
                message);
    }

}
