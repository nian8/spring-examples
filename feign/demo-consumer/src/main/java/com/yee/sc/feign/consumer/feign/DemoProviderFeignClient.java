package com.yee.sc.feign.consumer.feign;

import com.yee.sc.feign.consumer.config.DemoProviderFeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "feign-demo-provider",
        configuration = DemoProviderFeignClientConfiguration.class)
public interface DemoProviderFeignClient {

    @GetMapping("/echo")
    String echo(@RequestParam("name") String name);

}
