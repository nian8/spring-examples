package com.yee.sca.sentinel.consumer.fallback;

import com.yee.sca.sentinel.consumer.feign.DemoProviderFeignClient;

public class DemoProviderFeignClientFallback implements DemoProviderFeignClient {

    private Throwable throwable;

    public DemoProviderFeignClientFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String echo() {
        return "fallback:" + throwable.getClass().getSimpleName();
    }

}
