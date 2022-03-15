package com.yee.spring.ws.config;

import com.yee.spring.ws.endpoint.EchoWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/**
 * 开启 Spring WebSocket
 */
@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // WebSocket 通道
        registry
                // 配置处理器
                .addHandler(this.webSocketHandler(), "/echo")
                // 配置拦截器
                .addInterceptors(this.webSocketShakeInterceptor())
                // 解决跨域问题
                .setAllowedOrigins("*");
        // SockJS 通道
        // withSockJS() 方法声明我们想要使用 SockJS 功能，如果 WebSocket 不可用的话，会使用 SockJS；
        registry.addHandler(webSocketHandler(), "/sockjs/echo")
                .setAllowedOrigins("*").addInterceptors(webSocketShakeInterceptor())
                .withSockJS();
    }

    @Bean
    public EchoWebSocketHandler webSocketHandler() {
        return new EchoWebSocketHandler();
    }

    @Bean
    public EchoWebSocketShakeInterceptor webSocketShakeInterceptor() {
        return new EchoWebSocketShakeInterceptor();
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        // 在此处设置bufferSize
        container.setMaxTextMessageBufferSize(512000);
        container.setMaxBinaryMessageBufferSize(512000);
        container.setMaxSessionIdleTimeout(15 * 60000L);
        return container;
    }
}
