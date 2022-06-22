package com.yee.spring.ws.config;

import com.yee.spring.ws.handler.EchoWebSocketHandler;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import javax.annotation.Resource;
import java.util.UUID;

/**
 *
 */
@Slf4j
@Component
public class WebSocketManager implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketManager.class);

    @Resource
    EchoWebSocketHandler echoWebSocketHandler;

    /**
     * 定义websocket配置
     *
     * @return
     */
    @Bean(name = "wsClientConnectionManager")
    public WebSocketConnectionManager wsClientConnectionManager() {
        LOGGER.info("init websocket client connection manager - start");
        String token = UUID.randomUUID().toString();
        StandardWebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketConnectionManager manager = new WebSocketConnectionManager(webSocketClient,
                                                                            echoWebSocketHandler,
                                                                            "ws://localhost:8080/echo?token=" + token);
        manager.setAutoStartup(true);
        LOGGER.info("init websocket client connection manager - end");
        return manager;
    }

    @Lazy
    @Resource
    private WebSocketConnector socketConnector;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("Loading the client....");
        socketConnector.establishSocket();
    }
}
