package com.yee.spring.ws.config;

import com.yee.spring.ws.handler.EchoWebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import javax.annotation.Resource;
import java.util.UUID;

/**
 *
 */
@Configuration
public class WebSocketConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketConfiguration.class);

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

}
