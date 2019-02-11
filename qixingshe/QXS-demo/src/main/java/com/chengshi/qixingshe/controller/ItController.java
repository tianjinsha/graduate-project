package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.It;
import com.chengshi.qixingshe.service.IItCategoryService;
import com.chengshi.qixingshe.service.IItService;
import com.chengshi.qixingshe.util.PageHelper;
import com.chengshi.qixingshe.util.constant.obj_status;
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
 * @since 2018-12-10
 */
@Slf4j
@Controller
@RequestMapping("/it")
public class ItController {

    @Autowired
    IItService itService;

    @Autowired
    IItCategoryService itCategoryService;

    @GetMapping("list")
    public String itList(Model model, @RequestParam Map<String, Object> params, HttpServletRequest request) {
        model.addAttribute("fDate", params.get("fDate") == null ? "" : params.get("fDate"));
        model.addAttribute("tDate", params.get("tDate") == null ? "" : params.get("tDate"));
        model.addAttribute("title", params.get("title") == null ? "" : params.get("title"));
        model.addAttribute("category", params.get("category") == null ? "" : params.get("category"));
        model.addAttribute("status", params.get("status") == null ? "" : params.get("status"));
        model.addAttribute("url", PageHelper.getPageUrl(request));
        model.addAttribute("itCategory", itCategoryService.findItCategoryList());
        model.addAttribute("itList", itService.findItPages(new Query<>(params), new EntityWrapper<>()));
        return "/content/it/it-list";
    }

    @GetMapping("/page")
    @ResponseBody
    public Object page() {
        return itService.findItList();
    }

    @GetMapping("/add")
    public String itAdd(Model model) {
        model.addAttribute("itCategory", itCategoryService.findItCategoryList());
        return "/content/it/it-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Boolean itadd(@RequestBody It it) {
        return itService.addIt(it);
    }

    @GetMapping("/edit")
    public String itEdit(Model model) {
        model.addAttribute("itCategory", itCategoryService.findItCategoryList());
        return "/content/it/it-edit";
    }

    @PutMapping("/edit")
    @ResponseBody
    public Boolean itEdit(@RequestBody It it) {
        return itService.updateIt(it);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean itDelete(@PathVariable Integer id) {
        return itService.deleteIt(id);
    }

    @DeleteMapping("/batchDelete")
    @ResponseBody
    public Boolean itBatchDelete(@RequestBody List<Integer> ids) {
        return itService.batchDeleteIt(ids);
    }


    @PutMapping("/enable/{id}")
    @ResponseBody
    public Boolean itStatusEnable(@PathVariable Integer id) {
        return itService.changeItStatus(id, obj_status.STATUS_ENABLE);
    }

    @PutMapping("/disable/{id}")
    @ResponseBody
    public Boolean itStatusDisnable(@PathVariable Integer id) {
        return itService.changeItStatus(id, obj_status.STATUS_DISABLE);
    }

}

