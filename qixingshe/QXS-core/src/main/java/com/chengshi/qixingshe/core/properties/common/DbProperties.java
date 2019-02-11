package com.chengshi.qixingshe.core.properties.common;

import lombok.Data;

/**
 * @program: qixingshe
 * @author: tian
 * @description:存储相关得配置
 * @date: 2019/2/3 0:45
 */
@Data
public class DbProperties {

    /**
     * 缓存过期时间
     */
    private long cacheExpire=8460;
}
