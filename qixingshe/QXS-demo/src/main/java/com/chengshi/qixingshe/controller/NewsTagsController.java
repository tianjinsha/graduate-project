package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.News;
import com.chengshi.qixingshe.model.NewsTags;
import com.chengshi.qixingshe.service.INewsCategoryService;
import com.chengshi.qixingshe.service.INewsTagsService;
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
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Slf4j
@Controller
@RequestMapping("/newsTags")
public class NewsTagsController {

    @Autowired
    INewsTagsService newsTagsService;

    @Autowired
    INewsCategoryService newsCategoryService;

    @GetMapping("list")
    public String newsList(Model model, @RequestParam Map<String, Object> params, HttpServletRequest request){
        model.addAttribute("tname",params.get("tname")==null?"":params.get("tname"));
        model.addAttribute("category",params.get("category")==null?"":params.get("category"));
        model.addAttribute("url",PageHelper.getPageUrl(request));
        model.addAttribute("newsTagsList",newsTagsService.findNewsTagsPages(new Query<>(params),new EntityWrapper<>()));
        model.addAttribute("newsCategory",newsCategoryService.findNewsCategoryList());
        return "/content/news/news-tags";
    }

    @GetMapping("/page")
    @ResponseBody
    public Object page(){
        return newsTagsService.findNewsTagsList();
    }

    @GetMapping("/add")
    public String newsTagsAdd(Model model){
        model.addAttribute("newsCategory",newsCategoryService.findNewsCategoryList());
        return "content/news/newsTags-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Boolean newsTagsAdd(@RequestBody NewsTags newsTags){
        return  newsTagsService.addNewsTags(newsTags);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean newsTagsDelete(@PathVariable Integer id){
        log.info("id::"+id);
        return newsTagsService.deleteNewsTags(id);
    }


    @GetMapping("/edit/{id}")
    public String newsTagsEdit(@PathVariable  Integer id,Model model){
        model.addAttribute("newsTags",newsTagsService.findNewsTagsById(id));
        return "/content/news/newsTags-edit";
    }


    @PutMapping("/edit")
    @ResponseBody
    public Boolean newsTagsEdit(@RequestBody NewsTags newsTags){
        return newsTagsService.updateNewTags(newsTags);
    }

    @DeleteMapping("/batchDelete")
    @ResponseBody
    public Boolean newsTagsBatchDelete(@RequestBody List<Integer> ids){
        return newsTagsService.batchDeleteNewsTags(ids);
    }

}

