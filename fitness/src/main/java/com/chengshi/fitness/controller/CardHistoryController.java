package com.chengshi.fitness.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.fitness.model.CardHistory;
import com.chengshi.fitness.model.Member;
import com.chengshi.fitness.service.ICardHistoryService;
import com.chengshi.fitness.util.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 *  办卡记录 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@Slf4j
@RestController
@RequestMapping("/cardHistory")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CardHistoryController {

    @Autowired
    ICardHistoryService cardHistoryService;

    @GetMapping("/list")
    public Object list(@RequestParam Map<String, Object> params) {
        log.info("getCardHistoryList");
        Object obj = cardHistoryService.findCardHistoryPage(new Query<Object>(params), new EntityWrapper<CardHistory>());
        return obj;
    }


    @PostMapping("/add")
    public Boolean add(@RequestBody CardHistory cardHistory){
       return cardHistoryService.addCardHistory(cardHistory);
    }

}

