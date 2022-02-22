package com.yee.sc.rabbit.producer.controller;

import com.yee.sc.rabbit.producer.binder.Demo01OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo02OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo03OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo04OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo05OutputBinder;
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
    private Demo01OutputBinder demo01OutputBinder;

    @GetMapping("/send")
    public boolean sendSimple() {
        // 创建 Message
        EchoMessage message = new EchoMessage()
                .setId(new Random().nextInt());
        // 创建 Spring Message 对象
        Message<EchoMessage> springMessage = MessageBuilder.withPayload(message)
                .build();
        // 发送消息
        boolean sendResult = demo01OutputBinder.getChannel().send(springMessage);
        logger.info("[sendSimple][发送消息至 {} 完成, 结果 = {}]",
                Demo01OutputBinder.BINDING_NAME,
                sendResult);
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
            sendResult = demo01OutputBinder.getChannel().send(springMessage);
            logger.info("[sendTag][发送消息至 {} 完成, 结果 = {}]",
                    Demo01OutputBinder.BINDING_NAME,
                    sendResult);
        }
        return sendResult;
    }

    @Autowired
    private Demo02OutputBinder demo02OutputBinder;

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
        boolean sendResult = demo02OutputBinder.getChannel().send(springMessage);
        logger.info("[sendDelay][发送消息至 {} 完成, 结果 = {}]",
                Demo03OutputBinder.BINDING_NAME,
                sendResult);
        return sendResult;
    }

    @Autowired
    private Demo03OutputBinder demo03OutputBinder;

    @GetMapping("/send_retry")
    public boolean sendRetry() {
        // 创建 Message
        EchoMessage message = new EchoMessage()
                .setId(new Random().nextInt());
        // 创建 Spring Message 对象
        Message<EchoMessage> springMessage = MessageBuilder.withPayload(message)
                .build();
        // 发送消息
        boolean sendResult = demo03OutputBinder.getChannel().send(springMessage);
        logger.info("[sendRetry][发送消息至 {} 完成, 结果 = {}]",
                Demo03OutputBinder.BINDING_NAME,
                sendResult);
        return sendResult;
    }

    @Autowired
    private Demo04OutputBinder demo04OutputBinder;

    @GetMapping("/send_broadcast")
    public boolean sendBroadcast() {
        // 创建 Message
        EchoMessage message = new EchoMessage()
                .setId(new Random().nextInt());
        // 创建 Spring Message 对象
        Message<EchoMessage> springMessage = MessageBuilder.withPayload(message)
                .build();
        // 发送消息
        boolean sendResult = demo04OutputBinder.getChannel().send(springMessage);
        logger.info("[sendBroadcast][发送消息至 {} 完成, 结果 = {}]",
                Demo04OutputBinder.BINDING_NAME,
                sendResult);
        return sendResult;
    }

    @Autowired
    private Demo05OutputBinder demo05OutputBinder;

    @GetMapping("/send_orderly")
    public boolean sendOrderly() {
        boolean sendResult = false;
        // 发送 3 条相同 id 的消息
        int id = new Random().nextInt();
        for (int i = 0; i < 3; i++) {
            // 创建 Message
            EchoMessage message = new EchoMessage().setId(id);
            // 创建 Spring Message 对象
            Message<EchoMessage> springMessage = MessageBuilder.withPayload(message)
                    .build();
            // 发送消息
            sendResult = demo05OutputBinder.getChannel().send(springMessage);
            logger.info("[sendOrderly][发送消息至 {} 完成, 结果 = {}]",
                    Demo05OutputBinder.BINDING_NAME,
                    sendResult);
        }
        return sendResult;
    }
}
