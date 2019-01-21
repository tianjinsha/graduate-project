package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.ItCategory;
import com.chengshi.qixingshe.service.IItCategoryService;
import com.chengshi.qixingshe.util.PageHelper;
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
@RequestMapping("/itCategory")
public class ItCategoryController {
    @Autowired
    IItCategoryService itCategoryService;

    @GetMapping("list")
    public String itCategoryList(Model model, @RequestParam Map<String, Object> params, HttpServletRequest request) {
        model.addAttribute("cname", params.get("cname") == null ? "" : params.get("cname"));
        model.addAttribute("url", PageHelper.getPageUrl(request));
        model.addAttribute("itCategoryList", itCategoryService.findItCategoryPages(new Query<>(params), new EntityWrapper<>()));
        return "/content/it/it-category";
    }

    @GetMapping("/add")
    public String itCategoryAdd() {
        return "/content/it/itCategory-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Boolean itCategoryAdd(@RequestBody ItCategory itCategory) {
        return itCategoryService.addItCategory(itCategory);
    }


    @GetMapping("/edit/{id}")
    public String itCategoryEdit(@PathVariable Integer id,Model model) {
        model.addAttribute("itCategory",itCategoryService.findItCategoryById(id));
        return "/content/it/itCategory-edit";
    }

    @PutMapping("/edit")
    @ResponseBody
    public Boolean itCategoryEdit(@RequestBody ItCategory itCategory) {
        return itCategoryService.updateItCategory(itCategory);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean itCategoryDelete(@PathVariable Integer id){
        return itCategoryService.deleteItCategory(id);
    }

    @DeleteMapping("/batchDelete")
    @ResponseBody
    public Boolean ItCategoryBatchDelete(@RequestBody List<Integer> ids){
        return itCategoryService.batchDeleteItCategory(ids);
    }
}

