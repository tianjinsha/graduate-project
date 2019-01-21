package com.chengshi.qixingshe.core.properties.common;

import lombok.Data;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-20 23:00
 */
@Data
public class errorPageProperties {
    /**
     *404错误页面-地址找到
     */
    private String err404="/404.html";
    /**
     * 500错误页面
     */
    private String err500="/500.html";
}
