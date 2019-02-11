package com.chengshi.qixingshe.core.properties.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-02 22:57
 */
@Data
@Component
@ConfigurationProperties(prefix = "chengshi.qxs.common")
public class CommonProperties {

    private DbProperties db=new DbProperties();
    /**
     * 分页时每页显示的条数
     */
    private Integer pageSize = 10;

    /**
     * 自定义错误页面
     */
    private errorPageProperties errorPage = new errorPageProperties();
}
