package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.User;
import com.chengshi.qixingshe.service.IUserService;
import com.chengshi.qixingshe.service.IUserinfoService;
import com.chengshi.qixingshe.util.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    IUserinfoService userinfoService;

    @GetMapping("/{id}")
    @ResponseBody
    public User SelectUserById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }

    @ResponseBody
    @GetMapping("/findUserList")
    public List<User> findUserList() {
        return userService.findUserList();
    }

    /**
     * 分页-列出全部失效数据
     *
     * @param params
     * @param model
     * @return
     */
    @GetMapping("/pageDel")
    public String pageDelete(@RequestParam Map<String, Object> params, Model model, HttpServletRequest request) {

        model.addAttribute("nickname", params.get("nickname") == null ? "" : params.get("nickname"));
        model.addAttribute("fDate", params.get("fDate") == null ? "" : params.get("fDate"));
        model.addAttribute("tDate", params.get("tDate") == null ? "" : params.get("tDate"));
        model.addAttribute("status", params.get("status") == null ? "" : params.get("status"));
        model.addAttribute("url", PageHelper.getPageUrl(request));
        model.addAttribute("usersDel", userService.findUserPageDelete(new Query<>(params), new EntityWrapper<>()));

        return "/member/member-del";
    }

    /**
     * 分页-列出全部有效数据
     *
     * @param params
     * @param model
     * @return
     */
    @GetMapping("/page")
    public String page(@RequestParam Map<String, Object> params, Model model, HttpServletRequest request) {
        log.info("status:" + params.get("status"));
        model.addAttribute("nickname", params.get("nickname") == null ? "" : params.get("nickname"));
        model.addAttribute("fDate", params.get("fDate") == null ? "" : params.get("fDate"));
        model.addAttribute("tDate", params.get("tDate") == null ? "" : params.get("tDate"));
        model.addAttribute("status", params.get("status") == null ? "" : params.get("status"));
        model.addAttribute("url", PageHelper.getPageUrl(request));
        model.addAttribute("users", userService.findUserPage(new Query<>(params), new EntityWrapper<>()));

        return "/member/member-list";
    }

    @GetMapping("/edit")
    public String userEdit() {
        return "/member/member-edit";
    }

    /**
     * 恢复数据 1
     *
     * @param id
     * @return
     */
    @PutMapping("/recover/{id}")
    @ResponseBody
    public Object userRecover(@PathVariable Integer id) {
        log.info("id:" + id);
        return userService.recoverUser(id);
    }

    /**
     * 失效数据 0
     *
     * @param id
     * @return
     */
    @PutMapping("/disable/{id}")
    @ResponseBody
    public Object userDisable(@PathVariable Integer id) {
        log.info("id:" + id);
        return userService.disableUser(id);
    }

    /**
     * 停用数据 2
     *
     * @param id
     * @return
     */
    @PutMapping("/stop/{id}")
    @ResponseBody
    public Object userStop(@PathVariable Integer id) {
        log.info("id:" + id);
        return userService.stopUser(id);
    }

    /**
     * 彻底删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/del/{id}")
    @ResponseBody
    public Object userDel(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    /**
     * 批量失效
     *
     * @param
     * @return
     */
    @PutMapping("/batchDisable")
    @ResponseBody
    public Object userBatchDisable(@RequestBody List<Integer> ids) {
        for (Integer id : ids) {
            log.info("id:" + id);
        }

        return userService.batchDisableUser(ids);
    }

    /**
     * 批量恢复
     *
     * @param
     * @return
     */
    @PutMapping("/batchRecover")
    @ResponseBody
    public Object userBatchRecover(@RequestBody List<Integer> ids) {
        for (Integer id : ids) {
            log.info("id:" + id);
        }
        return userService.batchRecoverUser(ids);
    }
    /**
     * ***********************************************************************************
     */

    /**
     * 调整道用户密码修改也
     *
     * @return
     */
    @GetMapping("/userPass/{id}")
    public String userPassword(@PathVariable Integer id, Model model) {

        model.addAttribute("user", userService.findUserById(id));
        return "/member/member-password";
    }

    /**
     * 用户密码修改
     *
     * @param user
     * @return
     */
    @PutMapping("/userPass")
    public Object userPassword(User user) {
        return false;
    }
    /**
     * ***********************************************************************************
     */

    /**
     * 跳转到用户添加页面
     *
     * @return
     */
    @GetMapping("/add")
    public String userAdd() {
        return "/member/member-add";
    }

    /**
     * 用户添加
     *
     * @param user
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Boolean userAdd(@RequestBody User user) {
        return userService.addUser(user);
    }

}

