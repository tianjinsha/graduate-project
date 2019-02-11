package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.News;
import com.chengshi.qixingshe.service.INewsCategoryService;
import com.chengshi.qixingshe.service.INewsService;
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
@RequestMapping("/news")
public class NewsController {
    @Autowired
    INewsService newsService;
    @Autowired
    INewsCategoryService newsCategoryService;

    @GetMapping("list")
    public String newsList(Model model, @RequestParam Map<String, Object> params, HttpServletRequest request) {
        model.addAttribute("fDate", params.get("fDate") == null ? "" : params.get("fDate"));
        model.addAttribute("tDate", params.get("tDate") == null ? "" : params.get("tDate"));
        model.addAttribute("title", params.get("title") == null ? "" : params.get("title"));
        model.addAttribute("category", params.get("category") == null ? "" : params.get("category"));
        model.addAttribute("source", params.get("source") == null ? "" : params.get("source"));
        model.addAttribute("status", params.get("status") == null ? "" : params.get("status"));
        model.addAttribute("url", PageHelper.getPageUrl(request));
        model.addAttribute("newsCategory", newsCategoryService.findNewsCategoryList());
        model.addAttribute("newsList", newsService.findNewsPages(new Query<>(params), new EntityWrapper<>()));
        return "/content/news/news-list";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Object newsOne(@PathVariable Integer id) {
        return newsService.findNewsById(id);
    }

    @GetMapping("/page")
    @ResponseBody
    public Object newsList2(@RequestParam Map<String, Object> params, Model model, HttpServletRequest request) {

        return newsService.findNewsPages(new Query<>(params), new EntityWrapper<>());
    }

    @PostMapping("/add")
    @ResponseBody
    public Boolean newsAdd(@RequestBody News news) {
        return newsService.addNews(news);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean newsDelete(@PathVariable Integer id) {
        return newsService.deleteNews(id);
    }

    @DeleteMapping("/batchDelete")
    @ResponseBody
    public Boolean newsBatchDelete(@RequestBody List<Integer> ids) {
        return newsService.batchDeleteNews(ids);
    }

    @PutMapping("/disable/{id}")
    @ResponseBody
    public Boolean newsDisable(@PathVariable Integer id) {
        log.info("停用：" + id);
        return newsService.changeNewsStatus(id, obj_status.STATUS_DISABLE);
    }

    @PutMapping("/enable/{id}")
    @ResponseBody
    public Boolean newsEnable(@PathVariable Integer id) {
        log.info("启用：" + id);
        return newsService.changeNewsStatus(id, obj_status.STATUS_ENABLE);
    }


    @PutMapping("/batchEnable")
    @ResponseBody
    public Boolean newsBatchEnable(@RequestBody List<Integer> ids) {
        return newsService.batchChangeNewsStatus(ids, obj_status.STATUS_ENABLE);
    }

    @PutMapping("/batchDisable")
    @ResponseBody
    public Boolean newsBatchDisable(@RequestBody List<Integer> ids) {
        return newsService.batchChangeNewsStatus(ids, obj_status.STATUS_DISABLE);
    }


}

