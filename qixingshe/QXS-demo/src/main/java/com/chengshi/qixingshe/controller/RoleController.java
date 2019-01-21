package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Role;
import com.chengshi.qixingshe.service.IRoleService;
import com.chengshi.qixingshe.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-12-06
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    IRoleService roleService;

    /**
     * 角色列表
     * @param params
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String findRoleList(@RequestParam Map<String, Object> params, Model model,HttpServletRequest request){
        model.addAttribute("name",params.get("name")==null?"":params.get("name"));
        model.addAttribute("status",params.get("status")==null?"":params.get("status"));
        model.addAttribute("url",PageHelper.getPageUrl(request));
        model.addAttribute("roles",roleService.findRoleList(new Query<>(params),new EntityWrapper<>()));
        return "/member/role/role-list";
    }

    /**
     * 禁用角色
     * @param id
     * @return
     */
    @PutMapping("disable/{id}")
    @ResponseBody
    public Boolean roleDisable(@PathVariable Integer id){
        return roleService.disableRole(id);
    }

    /**
     * 解禁角色
     * @param id
     * @return
     */
    @PutMapping("enable/{id}")
    @ResponseBody
    public Boolean roleEnable(@PathVariable Integer id){
        return roleService.enableRole(id);
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    @ResponseBody
    public Boolean deleteRole(@PathVariable  Integer id){
        return  roleService.deleteRoleByid(id);
    }

    /**
     * 跳转到添加角色页面
     * @return
     */
    @GetMapping("/add")
    public String addRole(){
        return  "/member/role/role-add";
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public  Boolean addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

    /**
     * 跟新role
     * @param role
     * @return
     */
    @PutMapping("/update")
    @ResponseBody
    public Boolean  updateRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }

    @GetMapping("/edit/{id}")
    public String editRole(@PathVariable  Integer id,Model model){
        model.addAttribute("role",roleService.findRoleById(id));
        return "member/role/role-edit";
    }

    @PutMapping("/edit")
    @ResponseBody
    public Boolean editRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }
}

