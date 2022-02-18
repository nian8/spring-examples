package com.yee.sc.feign.consumer.controller;

import com.yee.sc.feign.consumer.feign.BaiduFeignClient;
import com.yee.sc.feign.consumer.feign.DemoProviderFeignClient;
import com.yee.sc.feign.provider.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsumerController {

    @Autowired
    private BaiduFeignClient baiduFeignClient;

    @Autowired
    private DemoProviderFeignClient demoProviderFeignClient;

    @GetMapping("/baidu/home")
    public String baiduHome() {
        // 使用 Feign 调用接口
        // 返回结果
        return baiduFeignClient.home();
    }

    @GetMapping("/hello")
    public String hello(String name) {
        // 使用 Feign 调用接口
        String response = demoProviderFeignClient.echo(name);
        // 返回结果
        return "consumer:" + response;
    }

    @GetMapping("/test_get_user")
    public UserDto testGetUser(@RequestParam("type") int type, UserDto userDTO) {
        // 方式一
        if (type == 1) {
            return demoProviderFeignClient.getUser(userDTO);
        } else if (type == 2) {
            return demoProviderFeignClient.getUser(userDTO.getUsername(), userDTO.getPassword());
        } else {
            // 方式三
            Map<String, Object> params = new HashMap<>();
            params.put("username", userDTO.getUsername());
            params.put("password", userDTO.getPassword());
            return demoProviderFeignClient.getUser(params);
        }
    }

    @GetMapping("/test_post_user")
    public UserDto testPostUser(UserDto userDTO) {
        return demoProviderFeignClient.postUser(userDTO);
    }

}
