package com.chengshi.qixingshe.core.properties.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 权限相关的相关属性
 *
 * @author tian
 * @date 2018年11月26日
 */

@Data
@Component("securityProperties")
@ConfigurationProperties(prefix = "chengshi.qxs.security")
public class SecurityProperties {
    /**
     * 浏览器属性
     */
    private BrowserProperties browser = new BrowserProperties();

    /**
     * 验证码属性
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();
}
