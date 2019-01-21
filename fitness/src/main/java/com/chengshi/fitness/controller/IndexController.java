package com.chengshi.fitness.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-16 21:16
 */
@RestController
public class IndexController {

    @RequestMapping("ping")
    public  String ping(){
        return "ping success !";
    }

}
