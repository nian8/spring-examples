package com.yee.sc.rabbit.producer.controller;

import com.yee.sc.rabbit.producer.binder.Demo01OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo02OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo03OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo04OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo05OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo06OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo07OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo08OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo09OutputBinder;
import com.yee.sc.rabbit.producer.binder.Demo10OutputBinder;
import com.yee.sc.rabbit.common.message.EchoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private Demo06OutputBinder demo06OutputBinder;

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
            sendResult = demo06OutputBinder.getChannel().send(springMessage);
            logger.info("[sendTag][发送消息至 {} 完成, 结果 = {}]",
                    Demo06OutputBinder.BINDING_NAME,
                    sendResult);
        }
        return sendResult;
    }

    @Autowired
    private Demo07OutputBinder demo07OutputBinder;

    @Transactional(transactionManager = "rabbitTransactionManager",
            rollbackFor = Exception.class)
    @GetMapping("/send_transaction")
    public boolean sendTransaction() throws InterruptedException {
        // 创建 Message
        int id = new Random().nextInt();
        EchoMessage message = new EchoMessage()
                .setId(id);
        // 创建 Spring Message 对象
        Message<EchoMessage> springMessage = MessageBuilder.withPayload(message)
                .build();
        // 发送消息
        boolean sendResult = demo07OutputBinder.getChannel().send(springMessage);
        logger.info("[syncSend][发送消息 [编号: {}] 至 {} 完成, 结果 = {}]",
                id,
                Demo07OutputBinder.BINDING_NAME,
                sendResult);
        // <X> 等待
        Thread.sleep(3 * 1000L);
        return sendResult;
    }

    @Autowired
    private Demo08OutputBinder demo08OutputBinder;

    @GetMapping("/send_ack")
    public boolean sendAck() {
        // 创建 Message
        EchoMessage message = new EchoMessage()
                .setId(new Random().nextInt());
        // 创建 Spring Message 对象
        Message<EchoMessage> springMessage = MessageBuilder.withPayload(message)
                .build();
        // 发送消息
        boolean sendResult = demo08OutputBinder.getChannel().send(springMessage);
        logger.info("[sendAck][发送消息 [编号: {}] 至 {} 完成, 结果 = {}]",
                message.getId(),
                Demo08OutputBinder.BINDING_NAME,
                sendResult);
        return sendResult;
    }

    @Autowired
    private Demo09OutputBinder demo09OutputBinder;

    @GetMapping("/send_confirm")
    public boolean sendConfirm() {
        // 创建 Message
        EchoMessage message = new EchoMessage()
                .setId(new Random().nextInt());
        // 创建 Spring Message 对象
        Message<EchoMessage> springMessage = MessageBuilder.withPayload(message)
                .build();
        // 发送消息
        boolean sendResult = demo09OutputBinder.getChannel().send(springMessage);
        logger.info("[sendConfirm][发送消息 [编号: {}] 至 {} 完成, 结果 = {}]",
                message.getId(),
                Demo09OutputBinder.BINDING_NAME,
                sendResult);
        return sendResult;
    }

    @Autowired
    private Demo10OutputBinder demo10OutputBinder;

    @GetMapping("/send_batch")
    public boolean sendBatch() throws InterruptedException {
        boolean sendResult = false;
        // 发送 10 条消息，每条中间间隔 10 秒
        for (int i = 0; i < 3; i++) {
            // 创建 Message
            EchoMessage message = new EchoMessage()
                    .setId(new Random().nextInt());
            // 创建 Spring Message 对象
            Message<EchoMessage> springMessage = MessageBuilder.withPayload(message)
                    .build();
            // 发送消息
            sendResult = demo10OutputBinder.getChannel().send(springMessage);

            // 故意每条消息之间，隔离 10 秒
            logger.info("[sendBatch][发送消息 [编号: {}] 至 {} 完成, 结果 = {}]",
                    message.getId(),
                    Demo10OutputBinder.BINDING_NAME,
                    sendResult);
            Thread.sleep(1000L);
        }
        return sendResult;
    }

}
