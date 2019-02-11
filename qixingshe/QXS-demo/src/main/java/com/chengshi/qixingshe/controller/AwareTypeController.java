package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.AwareType;
import com.chengshi.qixingshe.service.IAwareTypeService;
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
@RequestMapping("/awareType")
public class AwareTypeController {

    @Autowired
    IAwareTypeService awareTypeService;

    @GetMapping("list")
    public String newsList(Model model, @RequestParam Map<String, Object> params, HttpServletRequest request) {
        model.addAttribute("cname", params.get("cname") == null ? "" : params.get("cname"));
        model.addAttribute("url", PageHelper.getPageUrl(request));
        model.addAttribute("awareTypeList", awareTypeService.findAwareTypePages(new Query<>(params), new EntityWrapper<>()));
        return "/content/aware/aware-type";
    }

    @GetMapping("/add")
    public String awareTypeAdd() {
        return "/content/aware/awareType-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Boolean awareTypeAdd(@RequestBody AwareType awareType) {
        return awareTypeService.insert(awareType);
    }

    @GetMapping("/edit/{id}")
    public String newsTypeEdit(Model model, @PathVariable Integer id) {
        model.addAttribute("awareType", awareTypeService.findAwareTypeById(id));
        return "/content/aware/awareType-edit";
    }

    @PutMapping("/edit")
    @ResponseBody
    public Boolean AwareTypeEdit(@RequestBody AwareType awareType) {
        return awareTypeService.updateById(awareType);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean AwareTypeDelete(@PathVariable Integer id) {
        return awareTypeService.deleteAwareType(id);
    }

    @DeleteMapping("/batchDelete")
    @ResponseBody
    public Boolean AwareTypeBatchDelete(@RequestBody List<Integer> ids) {
        return awareTypeService.deleteBatchIds(ids);
    }

}

