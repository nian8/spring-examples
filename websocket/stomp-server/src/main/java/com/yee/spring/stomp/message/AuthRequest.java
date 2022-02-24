package com.yee.spring.stomp.message;

import com.yee.spring.stomp.common.model.Message;
import lombok.Getter;

/**
 * 用户认证请求
 */
@Getter
public class AuthRequest implements Message {

    public static final String TYPE = "AUTH_REQUEST";

    /**
     * 认证 Token
     */
    private String accessToken;

    public AuthRequest setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

}
