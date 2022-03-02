package com.yee.spring.ws.client;

import com.alibaba.fastjson.JSONObject;
import com.yee.spring.ws.model.SendReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.annotation.PostConstruct;
import java.net.URI;

@Service
public class WebsocketService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebsocketService.class);

    private final WebSocketClient webSocketClient = new StandardWebSocketClient();

    private WebSocketSession webSocketSession;

    @PostConstruct
    public void connect() {
        try {
            webSocketSession = webSocketClient.doHandshake(new TextWebSocketHandler() {
                @Override
                public void handleTextMessage(WebSocketSession session, TextMessage message) {
                    LOGGER.info("received message - " + message.getPayload());
                }

                @Override
                public void afterConnectionEstablished(WebSocketSession session) {
                    LOGGER.info("established connection - " + session);
                }
            }, new WebSocketHttpHeaders(), URI.create("ws://118.178.233.195:8080/demo")).get();
        } catch (Exception e) {
            LOGGER.error("Exception while accessing websockets", e);
        }
    }

    public void send(SendReq req) {
        try {
            TextMessage message = new TextMessage(JSONObject.toJSONString(req));
            if (!webSocketSession.isOpen()) {
                this.connect();
            }
            webSocketSession.sendMessage(message);
            LOGGER.info("sent message - " + message.getPayload());
        } catch (Exception e) {
            LOGGER.error("Exception while sending a message", e);
        }
    }
}
