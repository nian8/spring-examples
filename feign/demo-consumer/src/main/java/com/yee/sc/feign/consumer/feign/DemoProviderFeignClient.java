package com.yee.sc.feign.consumer.feign;

import com.yee.sc.feign.provider.api.ProviderService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "feign-demo-provider")
public interface DemoProviderFeignClient extends ProviderService {

}
