package com.chengshi.qixingshe.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-06 13:50
 */
@RestController
@RequestMapping("/client2")
public class DcController2 {
    org.slf4j.Logger logger = LoggerFactory.getLogger(DcController2.class);

    @GetMapping("/consumer")
    public String dc() {
        logger.info("======<call trace 1 /client2 DcController2>=======");
        return "this is eureka client provider";
    }
}
