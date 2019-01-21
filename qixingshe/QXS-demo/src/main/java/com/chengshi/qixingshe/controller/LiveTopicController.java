package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.LiveTopic;
import com.chengshi.qixingshe.service.ILiveService;
import com.chengshi.qixingshe.service.ILiveTopicService;
import com.chengshi.qixingshe.util.PageHelper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Controller
@RequestMapping("/liveTopic")
public class LiveTopicController {

    @Autowired
    ILiveTopicService liveTopicService;

    @GetMapping("list")
    public String liveTopicList(Model model, @RequestParam Map<String, Object> params, HttpServletRequest request){
        model.addAttribute("fDate",params.get("fDate")==null?"":params.get("fDate"));
        model.addAttribute("tDate",params.get("tDate")==null?"":params.get("tDate"));
        model.addAttribute("cname",params.get("cname")==null?"":params.get("cname"));
        model.addAttribute("url",PageHelper.getPageUrl(request));
        model.addAttribute("liveTopicList",liveTopicService.findLiveTopicPages(new Query<>(params),new EntityWrapper<>()));
        return "/content/live/live-topic";
    }

    @GetMapping("/add")
    public String liveTopicAdd(){
        return "/content/live/liveTopic-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Boolean liveTopicAdd(@RequestBody LiveTopic liveTopic){
        liveTopic.setCreateTime(new Date());
        return liveTopicService.insert(liveTopic);
    }

    @GetMapping("/edit/{id}")
    public String liveTopicEdit(@PathVariable Integer id,Model model){
        model.addAttribute("liveTopic",liveTopicService.findLiveTopicById(id));
        return "/content/live/liveTopic-edit";
    }

    @PutMapping("/edit")
    @ResponseBody
    public Boolean liveTopicEdit(@RequestBody LiveTopic liveTopic){
        return liveTopicService.updateById(liveTopic);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean liveTopicDelete(@PathVariable Integer id){
        return liveTopicService.deleteLiveTopic(id);
    }

    @DeleteMapping("batchDelete")
    @ResponseBody
    public Boolean liveTopicBatchDelete(@RequestBody List<Integer> ids){
        return liveTopicService.deleteBatchIds(ids);
    }


}

