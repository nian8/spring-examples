package com.yee.sc.feign.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 注意，保持 name 属性和 url 属性的 host 是一致的。
 */
@FeignClient(name = "baidu", url = "https://www.baidu.com")
public interface BaiduFeignClient {

    /**
     * 请求首页
     *
     * @return
     */
    @GetMapping("/")
    String home();

}
