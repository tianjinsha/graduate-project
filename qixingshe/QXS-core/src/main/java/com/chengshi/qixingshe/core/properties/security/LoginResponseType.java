package com.chengshi.qixingshe.core.properties.security;

/**
 * 登录确认后的操作，返回json或则跳转页面
 *
 * @author tian
 * @date 2018年11月26日
 */
public enum LoginResponseType {

    /**
     * 跳转
     */
    REDIRECT,

    /**
     * 返回json
     */
    JSON
}
