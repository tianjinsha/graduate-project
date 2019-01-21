package com.chengshi.fitness.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.fitness.model.Member;
import com.chengshi.fitness.service.IMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.chengshi.fitness.util.Query;
import java.util.Map;

/**
 * <p>
 * 会员 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@RestController
@RequestMapping("/member")
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
public class MemberController {

    @Autowired
    IMemberService memberService;

    @GetMapping("/list")
    public Object list(@RequestParam Map<String, Object> params){
        log.info("getMemberList");
        Object obj=memberService.findMemerPage(new Query<Object>(params),new EntityWrapper<Member>());
        return obj;
    }

    @RequestMapping(path = "/add",method = RequestMethod.POST,consumes = "application/json")
    public Boolean add(@RequestBody Member member){
        log.info("memberadd");
        return  memberService.addMember(member);
    }

    @GetMapping("/ping")
    public Object ping(){
        return "ping success";
    }
}

