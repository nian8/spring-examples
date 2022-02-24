package com.yee.spring.stomp.controller;

import com.alibaba.fastjson.JSONObject;
import com.yee.spring.stomp.message.SendToAllRequest;
import com.yee.spring.stomp.message.SendToUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SendController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * TODO https://blog.csdn.net/fly_leopard/article/details/78664409
     * 暂时先跳过
     *
     * @param message
     * @return
     */
    @MessageMapping("/send_to_all")
    @SendTo(value = "/topic/send_to_all")
    public SendToUserRequest sendToAll(SendToAllRequest message) {
        logger.info("[sendToAll][SendToAllRequest({})]", message);
        return new SendToUserRequest()
                .setMsgId(message.getMsgId())
                .setContent(message.getContent());
    }

    @SubscribeMapping("/topic/send_to_all")
    public void subSendToAll(SendToUserRequest message) {
        logger.info("[subSendToAll][SendToUserRequest({})]", JSONObject.toJSONString(message));
    }

}
