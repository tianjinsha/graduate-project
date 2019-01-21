package com.chengshi.qixingshe.core.properties.common;

import lombok.Data;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-02 22:57
 */
@Data
public class CommonProperties {

    /**
     *分页时每页显示的条数
     */
    private Integer pageSize=10;

    /**
     * 自定义错误页面
     */
    private errorPageProperties errorPage=new errorPageProperties();
}
