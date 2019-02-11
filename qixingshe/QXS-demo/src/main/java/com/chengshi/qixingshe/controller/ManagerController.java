package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Manager;
import com.chengshi.qixingshe.service.IManagerService;
import com.chengshi.qixingshe.util.PageHelper;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-12-01
 */
@Slf4j
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    IManagerService managerService;

    /**
     * 跳转到管理员列表
     *
     * @return
     */
    @GetMapping("/list")
    public String list(@RequestParam Map<String, Object> params, Model model, HttpServletRequest request) {
//        log.info("status:"+params.get("status"));
        model.addAttribute("account", params.get("account") == null ? "" : params.get("account"));
        model.addAttribute("fDate", params.get("fDate") == null ? "" : params.get("fDate"));
        model.addAttribute("tDate", params.get("tDate") == null ? "" : params.get("tDate"));
        model.addAttribute("status", params.get("status") == null ? "" : params.get("status"));
        model.addAttribute("url", PageHelper.getPageUrl(request));
        model.addAttribute("managers", managerService.findManagerPage(new Query<>(params), new EntityWrapper<>()));
        return "/admin/admin-list";
    }

    /**
     * 跳转到管理员添加
     *
     * @return
     */
    @GetMapping("/add")
    public String managerAdd() {
        return "admin/admin-add";
    }

    /**
     * 管理员添加
     *
     * @param manager
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Boolean managerAdd(@RequestBody Manager manager) {
        return managerService.addManager(manager);
    }

    /**
     * 跳转到管理员添加
     *
     * @return
     */
    @GetMapping("/edit/{id}")
    public String managerEdit(Model model, @PathVariable Integer id) {
        model.addAttribute("manager", managerService.findManagerById(id));
        return "admin/admin-edit";
    }

    /**
     * 管理员修改
     *
     * @param manager
     * @return
     */
    @PutMapping("/edit")
    @ResponseBody
    public Boolean managerEdit(@RequestBody Manager manager) {
        return managerService.updateManager(manager);
    }

    /**
     * 管理员删除
     *
     * @param id
     * @return
     */
    @ResponseBody
    @DeleteMapping("/delete/{id}")
    public Boolean managerDel(@PathVariable Integer id) {
        log.info("delete");
        return managerService.deleteManager(id);
    }

    /**
     * 禁用管理员
     *
     * @param id
     * @return
     */
    @ResponseBody
    @PutMapping("/disable/{id}")
    public Boolean managerDisable(@PathVariable Integer id) {
        log.info("disable");
        return managerService.disableManager(id);
    }

    /**
     * 开启管理员
     *
     * @param id
     * @return
     */
    @ResponseBody
    @PutMapping("/enable/{id}")
    public Boolean managerEnable(@PathVariable Integer id) {
        log.info("enable");
        return managerService.enableManager(id);
    }
}

