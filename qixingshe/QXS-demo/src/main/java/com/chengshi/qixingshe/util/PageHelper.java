package com.chengshi.qixingshe.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-05 20:42
 */
@Slf4j
public class PageHelper {
    public static String  getPageUrl(HttpServletRequest request){
        String args;
        String url =request.getContextPath()+request.getServletPath();
        log.info("requesturl:"+request.getQueryString());
        if(request.getQueryString()!=null){
            Pattern pattern=Pattern.compile("&?page=\\d+");
            Matcher matcher=pattern.matcher(request.getQueryString());
            if(matcher.find()){
                args=request.getQueryString().replaceAll("&?page=\\d+","");
                log.info("args:"+args);
            }else{
                args=request.getQueryString();
            }
            url=url+"?"+args+"&";
        }else{
            url=url+"?";
        }
        log.info("url:"+url);
        return url;
    }
}
