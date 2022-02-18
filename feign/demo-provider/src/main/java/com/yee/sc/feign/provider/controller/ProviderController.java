package com.yee.sc.feign.provider.controller;

import com.yee.sc.feign.provider.api.ProviderService;
import com.yee.sc.feign.provider.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController implements ProviderService {

    private final Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Value("${server.port}")
    private Integer serverPort;

    @Override
    public String echo(String name) {
        // 模拟执行 100ms 时长。方便后续我们测试请求超时
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 记录被调用的日志
        logger.info("[echo][被调用啦 name({})]", name);

        return serverPort + "-provider:" + name;
    }

    @Override
    public UserDto getUser(UserDto userDto) {
        return userDto;
    }

    @Override
    public UserDto postUser(UserDto userDto) {
        return userDto;
    }

}
