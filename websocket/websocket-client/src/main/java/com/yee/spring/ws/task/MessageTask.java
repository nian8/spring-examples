package com.yee.spring.ws.task;

import com.alibaba.fastjson.JSONObject;
import com.yee.spring.ws.handler.EchoWebSocketHandler;
import com.yee.spring.ws.model.SendReq;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketConnectionManager;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageTask {

    @Autowired
    EchoWebSocketHandler echoHandler;
    @Autowired
    WebSocketConnectionManager connectionManager;

    @Async
//    @Scheduled(cron = "0/15 * * * * ?")
    public void run() {
        //
        SendReq sendReq = new SendReq();
        sendReq.setSeq(RandomUtils.nextLong());
        Map<String, String> map = new HashMap<>(8);
        map.put("content", "hello world!");
        sendReq.setData(map);
        echoHandler.sendText(JSONObject.toJSONString(sendReq));
    }

    @Async
    @Scheduled(cron = "0/15 * * * * ?")
    public void ping() {
        if (!echoHandler.isConnected()) {
            connectionManager.startInternal();
        }
        echoHandler.sendPong();
    }
}
