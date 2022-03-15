package com.yee.spring.ws.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Component
public class EchoWebSocketHandler extends TextWebSocketHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(EchoWebSocketHandler.class);

    /**
     * 当前服务建立与服务端建立的链接信息
     */
    private WebSocketSession clientSession = null;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        this.clientSession = session;
        LOGGER.info("established connection - {}", session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        LOGGER.info("received message - {}", message.getPayload());
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        super.handlePongMessage(session, message);
    }

    /**
     * 发送消息,如果连接断开，缓存到数据库
     *
     * @param content 发送内容
     */
    public void sendText(String content) {
        if (!isConnected()) {
            // cache
            System.out.println("Connection closed ");
            System.out.println("Connection interrupt ");
            return;
        }
        TextMessage message = new TextMessage(content);
        try {
            this.clientSession.sendMessage(message);
            LOGGER.info("sent message - length: {}", content.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendPong() {
        if (!isConnected()) {
            // cache
            System.out.println("Connection closed ");
            System.out.println("Connection interrupt ");
            return;
        }
        PongMessage message = new PongMessage(ByteBuffer.wrap("1".getBytes(StandardCharsets.UTF_8)));
        try {
            this.clientSession.sendMessage(message);
            LOGGER.info("sent pong");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断连接是否存在
     *
     * @return
     */
    public boolean isConnected() {
        return null != this.clientSession && this.clientSession.isOpen();
    }

}
