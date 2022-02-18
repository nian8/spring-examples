package com.yee.sc.feign.provider.api;

import com.yee.sc.feign.provider.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProviderService {

    @GetMapping("/echo")
    String echo(@RequestParam("name") String name);

    @GetMapping("/get_user")
    UserDto getUser(UserDto userDto);

    @PostMapping("/post_user")
    UserDto postUser(@RequestBody UserDto userDto);

}
