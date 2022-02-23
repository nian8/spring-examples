package com.yee.sc.kafka.consumer.listener;

import com.yee.sc.kafka.common.message.EchoMessage;
import com.yee.sc.kafka.consumer.binder.Demo08InputBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Demo08Consumer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @StreamListener(Demo08InputBinder.BINDING_NAME)
    public void onMessage(@Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment,
                          @Payload EchoMessage message) throws IOException {
        logger.info("[onMessage][线程编号:{} 消息主题:{} 消息标签: {} 消息内容: {}]",
                Thread.currentThread().getId(),
                Demo08InputBinder.BINDING_NAME,
                "",
                message);
        // 提交消费进度
        boolean flag = message.getId() % 2 == 0;
        if (flag) {
            // 选择性提交，但会阻塞队列
            logger.info("{}", true);
            acknowledgment.acknowledge();
        }
        // ack 确认消息
    }

}
