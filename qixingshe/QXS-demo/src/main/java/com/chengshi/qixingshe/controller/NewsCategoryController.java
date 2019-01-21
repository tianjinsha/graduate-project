package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.NewsCategory;
import com.chengshi.qixingshe.service.INewsCategoryService;
import com.chengshi.qixingshe.util.PageHelper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/newsCategory")
public class NewsCategoryController {
    @Autowired
    INewsCategoryService newsCategoryService;

    @GetMapping("/list")
    public String newsCategoryList(Model model, @RequestParam Map<String, Object> params, HttpServletRequest request) {
        model.addAttribute("qname", params.get("qname") == null ? "" : params.get("qname"));
        model.addAttribute("url", PageHelper.getPageUrl(request));
        model.addAttribute("newsCategoryList", newsCategoryService.findNewsCategoryPages(new Query<>(params), new EntityWrapper<>()));
        return "/content/news/news-category";
    }

    @GetMapping("/add")
    public String newsCategoryAdd() {
        return "/content/news/newsCategory-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Boolean newsCategoryAdd(@RequestBody NewsCategory newsCategory) {
        return newsCategoryService.addNesCaregory(newsCategory);
    }

    @GetMapping("/edit/{id}")
    public String newsCategroyEdit(@PathVariable Integer id,Model model){
        model.addAttribute("newsCategory",newsCategoryService.findNewsCategoryById(id));
        return "/content/news/newsCategory-edit";
    }

    @ResponseBody
    @PutMapping("/edit")
    public Boolean newsCategoryEdit(@RequestBody NewsCategory newsCategory){
        return newsCategoryService.updateNewsCategory(newsCategory);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean newsCategoryDelete(@PathVariable Integer id) {
        return newsCategoryService.deleteNewsCategory(id);
    }

    @DeleteMapping("/batchDelete")
    @ResponseBody
    public Boolean newsCategoryBatchDelete(@RequestBody List<Integer> ids){
        return newsCategoryService.batchDeleteNewsCategory(ids);
    }

}

