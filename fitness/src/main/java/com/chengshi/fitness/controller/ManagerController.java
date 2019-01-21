package com.chengshi.fitness.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.fitness.model.Manager;
import com.chengshi.fitness.service.IManagerService;
import com.chengshi.fitness.service.IMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@Slf4j
@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    IManagerService managerService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/{id}")
    public Manager findByid(@PathVariable Integer id){
        EntityWrapper wrapper=new EntityWrapper();
        Manager manager=new Manager();
        manager.setId(id);
        wrapper.setEntity(manager);
        log.info(passwordEncoder.encode("root"));
        log.info(passwordEncoder.encode("mybatis"));
       return managerService.selectOne(wrapper);

    }

}

