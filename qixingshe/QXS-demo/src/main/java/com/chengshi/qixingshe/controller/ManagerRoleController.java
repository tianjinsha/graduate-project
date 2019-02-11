package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.ManagerRole;
import com.chengshi.qixingshe.service.IManagerRoleService;
import com.chengshi.qixingshe.util.PageHelper;
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
 * @since 2018-12-10
 */
@Slf4j
@Controller
@RequestMapping("/managerRole")
public class ManagerRoleController {

    @Autowired
    IManagerRoleService managerRoleService;

    /**
     * 跳转到管理员列表
     *
     * @return
     */
    @GetMapping("/list")
    public String list(@RequestParam Map<String, Object> params, Model model, HttpServletRequest request) {
//        log.info("status:"+params.get("status"));
        model.addAttribute("name", params.get("name") == null ? "" : params.get("name"));
        model.addAttribute("url", PageHelper.getPageUrl(request));
        model.addAttribute("status", params.get("status") == null ? "" : params.get("status"));
        model.addAttribute("managerRoles", managerRoleService.findManagerRolePage(new Query<>(params), new EntityWrapper<>()));
        return "/admin/admin-role";
    }

    /**
     * 跳转到管理员添加
     *
     * @return
     */
    @GetMapping("/add")
    public String managerRoleAdd() {
        return "admin/role-add";
    }

    /**
     * 管理员添加
     *
     * @param managerRole
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Boolean managerRoleAdd(@RequestBody ManagerRole managerRole) {
        return managerRoleService.addManager(managerRole);
    }

    /**
     * 跳转到管理员角色添加
     *
     * @return
     */
    @GetMapping("/edit/{id}")
    public String managerRoleEdit(Model model, @PathVariable Integer id) {
        model.addAttribute("managerRole", managerRoleService.findManagerRoleById(id));
        return "admin/role-edit";
    }

    /**
     * 管理员修改
     *
     * @param managerRole
     * @return
     */
    @PutMapping("/edit")
    @ResponseBody
    public Boolean managerEdit(@RequestBody ManagerRole managerRole) {
        return managerRoleService.updateManagerRole(managerRole);
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
        return managerRoleService.deleteManagerRole(id);
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
        return managerRoleService.disableManagerRole(id);
    }

    /**
     * 开启管理员
     *
     * @param id
     * @return
     */
    @ResponseBody
    @PutMapping("/enable/{id}")
    public Boolean managerRoleEnable(@PathVariable Integer id) {
        log.info("enable");
        return managerRoleService.enableManagerRole(id);
    }
}

