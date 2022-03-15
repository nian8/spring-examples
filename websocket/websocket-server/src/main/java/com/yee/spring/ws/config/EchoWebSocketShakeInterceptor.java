package com.yee.spring.ws.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 自定义 HttpSessionHandshakeInterceptor 拦截器
 * <p>
 * 因为 WebSocketSession 无法获得 ws 地址上的请求参数，所以只好通过该拦截器，获得 accessToken 请求参数，设置到 attributes 中
 */
public class EchoWebSocketShakeInterceptor extends HttpSessionHandshakeInterceptor {

    /**
     * 拦截 Handshake 事件
     *
     * @param request
     * @param response
     * @param wsHandler
     * @param attributes
     * @return
     * @throws Exception
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // 获得 accessToken
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
            //解决The extension [x-webkit-deflate-frame] is not supported问题
            if (request.getHeaders().containsKey(WebSocketHttpHeaders.SEC_WEBSOCKET_EXTENSIONS)) {
                request.getHeaders().set(WebSocketHttpHeaders.SEC_WEBSOCKET_EXTENSIONS, "permessage-deflate");
            }

            HttpSession session = serverRequest.getServletRequest().getSession();
            if (session == null) {
                return Boolean.FALSE;
            }
            //
            attributes.put("token", serverRequest.getServletRequest().getParameter("token"));
            // 调用父方法，继续执行逻辑
            return super.beforeHandshake(request, response, wsHandler, attributes);
        }
        return Boolean.FALSE;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler wsHandler, Exception ex) {
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
