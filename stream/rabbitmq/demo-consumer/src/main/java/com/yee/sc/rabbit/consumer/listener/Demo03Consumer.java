package com.yee.sc.rabbit.consumer.listener;

import com.yee.sc.rabbit.consumer.message.Demo03Target;
import com.yee.sc.rabbit.consumer.message.EchoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Demo03Consumer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @StreamListener(Demo03Target.DEMO_03_INPUT)
    public void onMessage(@Payload EchoMessage message) {
        logger.info("[onMessage][线程编号:{} 消息标签: {} 消息内容: {}]",
                Thread.currentThread().getId(),
                "",
                message);
        // <X> 注意，此处抛出一个 RuntimeException 异常，模拟消费失败
        throw new RuntimeException("我就是故意抛出一个异常");
    }

}
