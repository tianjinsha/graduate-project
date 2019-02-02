package com.chengshi.qixingshe.core;

import com.chengshi.qixingshe.core.properties.MineProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 读取自定义的配置
 * @author tian
 * @date 2018年11月25日
 */
@Configuration
@EnableConfigurationProperties(MineProperties.class)
public class SecurityCoreConfig {

    @Bean
    public PasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
