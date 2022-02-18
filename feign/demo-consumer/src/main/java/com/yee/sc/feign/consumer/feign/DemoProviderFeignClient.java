package com.yee.sc.feign.consumer.feign;

import com.yee.sc.feign.provider.api.ProviderService;
import com.yee.sc.feign.provider.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "feign-demo-provider")
public interface DemoProviderFeignClient extends ProviderService {

    /**
     * GET 方式一，最推荐
     * <p>
     * {@link org.springframework.cloud.openfeign.SpringQueryMap}
     * {@link feign.QueryMap}
     *
     * @param userDto dto
     * @return dto
     */
    @GetMapping("/get_user")
    UserDto getUser(@SpringQueryMap UserDto userDto);

    /**
     * GET 方式二，相对推荐
     *
     * @param username username
     * @param password password
     * @return dto
     */
    @GetMapping("/get_user")
    UserDto getUser(@RequestParam("username") String username, @RequestParam("password") String password);

    /**
     * GET 方式三，不推荐
     *
     * @param params dto
     * @return dto
     */
    @GetMapping("/get_user")
    UserDto getUser(@RequestParam Map<String, Object> params);

    /**
     * POST 方式
     * <p>
     * 与父方法相同
     *
     * @param userDto dto
     * @return dto
     */
    @Override
    @PostMapping("/post_user")
    UserDto postUser(@RequestBody UserDto userDto);

}
