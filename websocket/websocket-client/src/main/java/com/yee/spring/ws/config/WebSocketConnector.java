package com.yee.spring.ws.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketConnectionManager;

import javax.annotation.Resource;

@Slf4j
@Configuration
public class WebSocketConnector {

    @Resource(name = "wsClientConnectionManager")
    private WebSocketConnectionManager manager;

    public void establishSocket() {
        log.info("Establishing socket...");
    }

    public void reconnect() {
        manager.stop();
        manager.start();
    }

}
