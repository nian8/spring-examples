package com.yee.sc.rabbit.consumer.listener;

import com.rabbitmq.client.Channel;
import com.yee.sc.rabbit.consumer.binder.Demo08InputBinder;
import com.yee.sc.rabbit.common.message.EchoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Demo08Consumer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @StreamListener(Demo08InputBinder.BINDING_NAME)
    public void onMessage(@Header(AmqpHeaders.CHANNEL) Channel channel,
                          @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
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
            logger.info("{}", flag);
        }
        // ack 确认消息
        // 第二个参数 multiple ，用于批量确认消息，为了减少网络流量，手动确认可以被批处。
        // 1. 当 multiple 为 true 时，则可以一次性确认 deliveryTag 小于等于传入值的所有消息
        // 2. 当 multiple 为 false 时，则只确认当前 deliveryTag 对应的消息
        channel.basicAck(deliveryTag, false);
    }

}
