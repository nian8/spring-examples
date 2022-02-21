package com.yee.sc.rabbit.consumer.listener;

import com.yee.sc.rabbit.consumer.message.Demo03Target;
import com.yee.sc.rabbit.consumer.message.EchoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.ErrorMessage;
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

    /**
     * 局部异常处理器：通过订阅指定错误 Channel
     * 在全局和局部异常处理都定义的情况下，错误消息仅会被符合条件的局部错误异常处理。如果没有符合条件的，错误消息才会被全局异常处理
     *
     * <p>
     * 错误 Channel: <destination>.<group>.errors
     *
     * @param errorMessage
     */
    @ServiceActivator(inputChannel = "DEMO-TOPIC-03.demo-consumer-group-DEMO-TOPIC-03.errors")
    public void handleError(ErrorMessage errorMessage) {
        logger.error("[handleError][payload：{}]", errorMessage.getPayload().getMessage());
        logger.error("[handleError][originalMessage：{}]", errorMessage.getOriginalMessage());
        logger.error("[handleError][headers：{}]", errorMessage.getHeaders());
    }

}
