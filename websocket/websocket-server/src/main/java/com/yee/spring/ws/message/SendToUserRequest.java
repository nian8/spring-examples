package com.yee.spring.ws.message;

import com.yee.spring.ws.common.model.Message;
import lombok.Getter;

/**
 * 发送消息给一个用户的 Message
 */
@Getter
public class SendToUserRequest implements Message {

    public static final String TYPE = "SEND_TO_USER_REQUEST";

    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;

    public SendToUserRequest setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public SendToUserRequest setContent(String content) {
        this.content = content;
        return this;
    }

}
