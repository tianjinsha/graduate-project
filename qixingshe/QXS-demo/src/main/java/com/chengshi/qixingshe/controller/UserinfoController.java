package com.chengshi.qixingshe.controller;


import com.chengshi.qixingshe.service.IUserinfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-12-01
 */
@Controller
@Slf4j
@RequestMapping("/userinfo")
public class UserinfoController {

    @Autowired
    IUserinfoService userinfoService;

    /**
     * 跳转到用户信息修改页面
     *
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    public String userEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("userinfo", userinfoService.findUserInfoByUserId(id));
        log.info(userinfoService.findUserInfoByUserId(id).toString());
        return "/member/member-edit";
    }

}

