package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.ItTags;
import com.chengshi.qixingshe.service.IItCategoryService;
import com.chengshi.qixingshe.service.IItTagsService;
import com.chengshi.qixingshe.util.PageHelper;
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
@Controller
@RequestMapping("/itTags")
public class ItTagsController {

    @Autowired
    IItTagsService iItTagsService;
    @Autowired
    IItCategoryService itCategoryService;

    @GetMapping("list")
    public String itTagsList(Model model, @RequestParam Map<String, Object> params, HttpServletRequest request) {
        model.addAttribute("tname", params.get("tname") == null ? "" : params.get("tname"));
        model.addAttribute("category", params.get("category") == null ? "" : params.get("category"));
        model.addAttribute("url", PageHelper.getPageUrl(request));
        model.addAttribute("itCategory", itCategoryService.findItCategoryList());
        model.addAttribute("itTagsList", iItTagsService.findItTagsPages(new Query<>(params), new EntityWrapper<>()));
        return "/content/it/it-tags";
    }

    @ResponseBody
    @GetMapping("/page")
    public Object page() {
        return iItTagsService.findItTagsList();
    }

    @GetMapping("/add")
    public String itTagsAdd(Model model) {
        model.addAttribute("itCategory", itCategoryService.findItCategoryList());
        return "/content/it/itTags-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Boolean itTagsAdd(@RequestBody ItTags itTags) {
        return iItTagsService.addItTags(itTags);
    }

    @GetMapping("/edit/{id}")
    public String itTagsEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("itTags", iItTagsService.findItTagsById(id));
        model.addAttribute("itCategory", itCategoryService.findItCategoryList());
        return "/content/it/itTags-edit";
    }

    @PutMapping("/edit")
    @ResponseBody
    public Boolean itTagsEdit(@RequestBody ItTags itTags) {
        return iItTagsService.updateItTags(itTags);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean itTagsDelete(@PathVariable Integer id) {
        return iItTagsService.deleteItTags(id);
    }

    @DeleteMapping("/batchDelete")
    @ResponseBody
    public Boolean itTagsBatchDelete(@RequestBody List<Integer> ids) {
        return iItTagsService.batchDeleteItTags(ids);
    }

}

