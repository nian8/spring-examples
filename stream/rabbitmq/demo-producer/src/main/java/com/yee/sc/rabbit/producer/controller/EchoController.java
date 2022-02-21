package com.yee.sc.rabbit.producer.controller;

import com.yee.sc.rabbit.producer.message.Demo01Source;
import com.yee.sc.rabbit.producer.message.Demo02Source;
import com.yee.sc.rabbit.producer.message.Demo03Source;
import com.yee.sc.rabbit.producer.message.EchoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/echo")
public class EchoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo01Source demo01Source;
    @Autowired
    private Demo02Source demo02Source;
    @Autowired
    private Demo03Source demo03Source;

    @GetMapping("/send")
    public boolean send() {
        // 创建 Message
        EchoMessage message = new EchoMessage()
                .setId(new Random().nextInt());
        // 创建 Spring Message 对象
        Message<EchoMessage> springMessage = MessageBuilder.withPayload(message)
                .build();
        // 发送消息
        boolean sendResult = demo01Source.getChannel().send(springMessage);
        logger.info("[send][发送消息完成, 结果 = {}]", sendResult);
        return sendResult;
    }

    @GetMapping("/send_tag")
    public boolean sendTag() {
        boolean sendResult = false;
        for (String tag : new String[]{"yunai", "yutou", "tudou"}) {
            // 创建 Message
            EchoMessage message = new EchoMessage()
                    .setId(new Random().nextInt());
            // 创建 Spring Message 对象
            Message<EchoMessage> springMessage = MessageBuilder.withPayload(message)
                    // 设置 Tag
                    .setHeader("tag", tag)
                    .build();
            // 发送消息
            sendResult = demo01Source.getChannel().send(springMessage);
            logger.info("[sendTag][发送消息完成, 结果 = {}]", sendResult);
        }
        return sendResult;
    }

    @GetMapping("/send_delay")
    public boolean sendDelay() {
        // 创建 Message
        EchoMessage message = new EchoMessage()
                .setId(new Random().nextInt());
        // 创建 Spring Message 对象
        Message<EchoMessage> springMessage = MessageBuilder.withPayload(message)
                // 设置延迟时间，单位：毫秒
                .setHeader("x-delay", 5000)
                .build();
        // 发送消息
        boolean sendResult = demo02Source.getChannel().send(springMessage);
        logger.info("[sendDelay][发送消息完成, 结果 = {}]", sendResult);
        return sendResult;
    }

    @GetMapping("/send_retry")
    public boolean sendRetry() {
        // 创建 Message
        EchoMessage message = new EchoMessage()
                .setId(new Random().nextInt());
        // 创建 Spring Message 对象
        Message<EchoMessage> springMessage = MessageBuilder.withPayload(message)
                .build();
        // 发送消息
        boolean sendResult = demo03Source.getChannel().send(springMessage);
        logger.info("[sendRetry][发送消息完成, 结果 = {}]", sendResult);
        return sendResult;
    }

}
