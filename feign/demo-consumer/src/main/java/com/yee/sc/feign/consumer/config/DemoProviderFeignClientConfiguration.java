package com.yee.sc.feign.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 服务 feign-demo-provider 的 FeignClient 配置类
 */
public class DemoProviderFeignClientConfiguration {

    /**
     * 主 Bean
     * 优先使用
     * @return
     */
    @Primary
    @Bean
    public Logger.Level feignClientLoggerLevel() {
        return Logger.Level.FULL;
    }

}
