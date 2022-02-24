package com.yee.spring.stomp.message;

import com.yee.spring.stomp.common.model.Message;
import lombok.Getter;

/**
 * 发送给所有人的群聊消息的 Message
 */
@Getter
public class SendToAllRequest implements Message {

    public static final String TYPE = "SEND_TO_ALL_REQUEST";

    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;

    public SendToAllRequest setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public SendToAllRequest setContent(String content) {
        this.content = content;
        return this;
    }

}
