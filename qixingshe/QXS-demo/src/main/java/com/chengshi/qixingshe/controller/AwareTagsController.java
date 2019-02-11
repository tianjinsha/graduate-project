package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.AwareTags;
import com.chengshi.qixingshe.model.AwareType;
import com.chengshi.qixingshe.service.IAwareTagsService;
import com.chengshi.qixingshe.service.IAwareTypeService;
import com.chengshi.qixingshe.util.PageHelper;
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
 * 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Controller
@RequestMapping("/awareTags")
public class AwareTagsController {

    @Autowired
    IAwareTagsService awareTagsService;

    @Autowired
    IAwareTypeService awareTypeService;

    @GetMapping("/list")
    public String newsList(Model model, @RequestParam Map<String, Object> params, HttpServletRequest request) {
        model.addAttribute("tname", params.get("tname") == null ? "" : params.get("tname"));
        model.addAttribute("category", params.get("category") == null ? "" : params.get("category"));
        model.addAttribute("url", PageHelper.getPageUrl(request));
        model.addAttribute("awareType", awareTypeService.findAwareTypeList());
        model.addAttribute("awareTagsList", awareTagsService.findAwareTagsPages(new Query<>(params), new EntityWrapper<>()));
        return "/content/aware/aware-tags";
    }

    @GetMapping("/add")
    public String awareTagsAdd(Model model) {
        model.addAttribute("awareType", awareTypeService.findAwareTypeList());
        return "/content/aware/awareTags-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Boolean awareTagAdd(@RequestBody AwareTags awareTags) {
        awareTags.setCreateTime(new Date());
        return awareTagsService.insert(awareTags);
    }

    @GetMapping("/edit/{id}")
    public String newsTagsEdit(Model model, @PathVariable Integer id) {
        model.addAttribute("awareType", awareTypeService.findAwareTypeList());
        model.addAttribute("awareTags", awareTagsService.findAwareTagsById(id));
        return "/content/aware/awareTags-edit";
    }

    @PutMapping("/edit")
    @ResponseBody
    public Boolean AwareTypeEdit(@RequestBody AwareTags awareTags) {
        return awareTagsService.updateById(awareTags);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean AwareTagsDelete(@PathVariable Integer id) {
        return awareTagsService.deleteAwareTags(id);
    }

    @DeleteMapping("/batchDelete")
    @ResponseBody
    public Boolean AwareTagsBatchDelete(@RequestBody List<Integer> ids) {
        return awareTagsService.deleteBatchIds(ids);
    }


}

