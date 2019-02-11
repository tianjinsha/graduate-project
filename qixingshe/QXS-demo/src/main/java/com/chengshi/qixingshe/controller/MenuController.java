package com.chengshi.qixingshe.controller;


import com.chengshi.qixingshe.service.IMenuService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-12-28
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    IMenuService menuService;

    @GetMapping("/list")
    public String menuList(Model model) {
        model.addAttribute("menuList", menuService.findMenuList());
        return "/system/menu-list";
    }

    @GetMapping("/add")
    public String menuAdd() {
        return "/system/menu-add";
    }

    @GetMapping("/edit")
    public String menuEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("menu", menuService.findMenuByid(id));
        return "/system/menu-edit";
    }
}

