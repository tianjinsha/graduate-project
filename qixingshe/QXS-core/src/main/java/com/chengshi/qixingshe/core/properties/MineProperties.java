package com.chengshi.qixingshe.core.properties;

import com.chengshi.qixingshe.core.properties.common.CommonProperties;
import com.chengshi.qixingshe.core.properties.security.SecurityProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-02 22:58
 */
@Data
@Component
@ConfigurationProperties(prefix = "chengshi.qixingshe")
public class MineProperties {
    /**
     * 通用配置
     */
    CommonProperties common;
    /**
     *安全属性
     */
    SecurityProperties security;
}
