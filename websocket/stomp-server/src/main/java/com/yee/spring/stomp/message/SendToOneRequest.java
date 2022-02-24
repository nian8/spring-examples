package com.yee.spring.stomp.message;

import com.yee.spring.stomp.common.model.Message;
import lombok.Getter;

/**
 * 发送给指定人的私聊消息的 Message
 */
@Getter
public class SendToOneRequest implements Message {

    public static final String TYPE = "SEND_TO_ONE_REQUEST";

    /**
     * 发送给的用户
     */
    private String toUser;
    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;

    public SendToOneRequest setToUser(String toUser) {
        this.toUser = toUser;
        return this;
    }

    public SendToOneRequest setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public SendToOneRequest setContent(String content) {
        this.content = content;
        return this;
    }
}
