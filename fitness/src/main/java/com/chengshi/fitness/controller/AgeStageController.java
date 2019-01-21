package com.chengshi.fitness.controller;


import com.chengshi.fitness.model.AgeStage;
import com.chengshi.fitness.service.IAgeStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 年龄阶段 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@Controller
@RequestMapping("/ageStage")
public class AgeStageController {

    @Autowired
    IAgeStageService ageStageService;

    @GetMapping("/list")
    public Object list(){
        return ageStageService.findAgeStateList();
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable  Integer id){
        return ageStageService.findAgeStageById(id);
    }

    public Boolean update(@RequestBody AgeStage ageStage){

        return ageStageService.updateAgeStage(ageStage);
    }

}

