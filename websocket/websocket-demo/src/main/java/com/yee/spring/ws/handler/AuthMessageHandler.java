package com.yee.spring.ws.handler;

import com.yee.spring.ws.common.handler.MessageHandler;
import com.yee.spring.ws.message.AuthRequest;
import com.yee.spring.ws.message.AuthResponse;
import com.yee.spring.ws.message.UserJoinNoticeRequest;
import com.yee.spring.ws.util.WebSocketUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.websocket.Session;

@Component
public class AuthMessageHandler implements MessageHandler<AuthRequest> {

    @Override
    public void execute(Session session, AuthRequest message) {
        // 如果未传递 accessToken
        if (ObjectUtils.isEmpty(message.getAccessToken())) {
            WebSocketUtil.send(session, AuthResponse.TYPE,
                    new AuthResponse().setCode(1).setMessage("认证 accessToken 未传入"));
            return;
        }

        // 添加到 WebSocketUtil 中
        // 考虑到代码简化，我们先直接使用 accessToken 作为 User
        WebSocketUtil.addSession(session, message.getAccessToken());

        // 判断是否认证成功。这里，假装直接成功
        WebSocketUtil.send(session, AuthResponse.TYPE, new AuthResponse().setCode(0));

        // 通知所有人，某个人加入了。这个是可选逻辑，仅仅是为了演示
        // 考虑到代码简化，我们先直接使用 accessToken 作为 User
        WebSocketUtil.broadcast(UserJoinNoticeRequest.TYPE,
                new UserJoinNoticeRequest().setNickname(message.getAccessToken()));
    }

    @Override
    public String getType() {
        return AuthRequest.TYPE;
    }

}
