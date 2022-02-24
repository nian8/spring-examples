package com.yee.spring.ws.message;

import com.yee.spring.ws.common.model.Message;
import lombok.Getter;

/**
 * 用户加入群聊的通知 Message
 */
@Getter
public class UserJoinNoticeRequest implements Message {

    public static final String TYPE = "USER_JOIN_NOTICE_REQUEST";

    /**
     * 昵称
     */
    private String nickname;

    public UserJoinNoticeRequest setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

}
