package com.yee.sca.sentinel.consumer.feign;

import com.yee.sca.sentinel.consumer.fallback.DemoProviderFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "demo-provider", url = "http://127.0.0.1:8080",
    fallbackFactory = DemoProviderFeignClientFallbackFactory.class)
public interface DemoProviderFeignClient {

    @GetMapping("/demo/echo")
    String echo();

}
