package com.chengshi.qixingshe.controller;

import com.chengshi.qixingshe.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-01 19:45
 */
@Controller
@Slf4j
public class IndexController {
    @GetMapping(path = {"/index",""})
    public String index(){
        return "/index";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "/welcome";
    }
    @GetMapping("/test")
    public String test(ModelMap map){
        List<User> users=new ArrayList<>();
        User user=new User();
        User user2=new User();
        user.setId(1);
        user.setNickname("tian");
        users.add(user);
        user2.setId(2);
        user2.setNickname("jin");
        users.add(user2);
        map.addAttribute("test","This  is a test");
        map.addAttribute("users",users);
        return "/test";
    }
}
