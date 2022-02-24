package com.yee.spring.ws.config;

import com.yee.spring.ws.endpoint.DemoWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * 开启 Spring WebSocket
 */
@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                // 配置处理器
                .addHandler(this.webSocketHandler(), "/")
                // 配置拦截器
                .addInterceptors(new EchoWebSocketShakeInterceptor())
                // 解决跨域问题
                .setAllowedOrigins("*");
    }

    @Bean
    public DemoWebSocketHandler webSocketHandler() {
        return new DemoWebSocketHandler();
    }

    @Bean
    public EchoWebSocketShakeInterceptor webSocketShakeInterceptor() {
        return new EchoWebSocketShakeInterceptor();
    }

}
