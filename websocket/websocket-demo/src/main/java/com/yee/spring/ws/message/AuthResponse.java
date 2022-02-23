package com.yee.spring.ws.message;

import com.yee.spring.ws.common.model.Message;
import lombok.Getter;

/**
 * 用户认证响应
 */
@Getter
public class AuthResponse implements Message {

    public static final String TYPE = "AUTH_RESPONSE";

    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应提示
     */
    private String message;

    public AuthResponse setCode(Integer code) {
        this.code = code;
        return this;
    }

    public AuthResponse setMessage(String message) {
        this.message = message;
        return this;
    }

}
