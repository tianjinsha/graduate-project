package com.chengshi.qixingshe.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Live;
import com.chengshi.qixingshe.service.ILiveService;
import com.chengshi.qixingshe.util.PageHelper;
import com.chengshi.qixingshe.util.constant.obj_status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Controller
@RequestMapping("/live")
public class LiveController {

    @Autowired
    ILiveService liveService;

    @GetMapping("list")
    public String liveList(Model model, @RequestParam Map<String, Object> params, HttpServletRequest request) {
        model.addAttribute("fDate", params.get("fDate") == null ? "" : params.get("fDate"));
        model.addAttribute("tDate", params.get("tDate") == null ? "" : params.get("tDate"));
        model.addAttribute("title", params.get("title") == null ? "" : params.get("title"));
        model.addAttribute("status", params.get("status") == null ? "" : params.get("status"));
        model.addAttribute("url", PageHelper.getPageUrl(request));
        model.addAttribute("liveList", liveService.findLivePages(new Query<>(params), new EntityWrapper<>()));
        return "/content/live/live-list";
    }

    @GetMapping("/add")
    public String liveAdd() {
        return "/content/live/live-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Boolean liveAdd(@RequestBody Live live) {
        live.setCreateTime(new Date());
        return liveService.insert(live);
    }

    @GetMapping("/edit/{id}")
    public String liveEdit(Model model, @PathVariable Integer id) {
        model.addAttribute("live", liveService.findLiveById(id));
        return "/content/live/live-edit";
    }

    @PutMapping("/edit")
    @ResponseBody
    public Boolean liveEdit(@RequestBody Live live) {
        return liveService.updateById(live);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean liveDelete(@PathVariable Integer id) {
        return liveService.deleteLive(id);
    }

    @DeleteMapping("/batchDelete")
    @ResponseBody
    public Boolean liveBatchDelete(@RequestBody List<Integer> ids) {
        return liveService.deleteBatchIds(ids);
    }

    @PutMapping("/disable/{id}")
    @ResponseBody
    public Boolean liveTopicDisable(@PathVariable Integer id) {
        return liveService.changeLiveStatus(id, obj_status.STATUS_DISABLE);
    }

    @PutMapping("/enable/{id}")
    @ResponseBody
    public Boolean liveTopicEnable(@PathVariable Integer id) {
        return liveService.changeLiveStatus(id, obj_status.STATUS_ENABLE);
    }
}

