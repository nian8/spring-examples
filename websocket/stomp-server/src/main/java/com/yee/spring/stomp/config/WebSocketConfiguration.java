package com.yee.spring.stomp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 开启 Spring WebSocket 对 Stomp 的支持
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //
        registry.enableSimpleBroker("/topic");
        //
        registry.setApplicationDestinationPrefixes("/app");
    }

    /**
     * #withSockJS 方法定义了支持 SockJS 连接，
     * 优先使用原生的 WebSocket，
     * 如果浏览器不支持，则降级使用 SockJS
     *
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/im")
                .withSockJS();
    }

}
