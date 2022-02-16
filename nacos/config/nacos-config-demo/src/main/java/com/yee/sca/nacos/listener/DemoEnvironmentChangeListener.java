package com.yee.sca.nacos.listener;

import org.apache.commons.lang3.StringUtils;
import org.jasypt.encryption.StringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.environment.EnvironmentManager;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

/**
 * 自定义环境变更监听器
 * <p>
 * {@link org.springframework.cloud.logging.LoggingRebinder}
 */
@Component
public class DemoEnvironmentChangeListener implements ApplicationListener<EnvironmentChangeEvent> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ConfigurableEnvironment environment;

    /**
     * Environment 管理器，可以实现配置项的获取和修改
     */
    @Autowired
    private EnvironmentManager environmentManager;

    /**
     * Jasypt 加密器，可以对配置项进行加密和解密
     */
    @Autowired
    private StringEncryptor encryptor;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        for (String key : event.getKeys()) {
            String value = environment.getProperty(key);
            logger.info("[onApplicationEvent][key({}) 最新 value 为 {}]", key, value);

            // 判断 value 是否为加密。如果是，则进行解密
            if (StringUtils.isNotEmpty(value) &&
                    value.startsWith("ENC(") && value.endsWith(")")
            ) {
                value = encryptor.decrypt(StringUtils.substringBetween(value, "ENC(", ")"));
                logger.info("[onApplicationEvent][key({}) 解密后为 {}]", key, value);
                // 设置到 Environment 中
                // jasypt 会自动将解密后的“值”赋予“键”
//                environmentManager.setProperty(key, value);
            }
        }
    }

}
