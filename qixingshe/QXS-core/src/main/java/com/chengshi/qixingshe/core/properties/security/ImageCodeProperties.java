package com.chengshi.qixingshe.core.properties.security;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图片验证码的相关属性
 *
 * @author tian
 * @date 2018年11月26日
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImageCodeProperties extends SmsCodeProperties {

    /**
     * 图片验证码的宽度
     */
    private int width = 67;
    /**
     * 图片验证码的高度
     */
    private int height = 23;

    /**
     * 设置默认长度为4
     */
    public ImageCodeProperties() {
        setLength(4);
    }
}
