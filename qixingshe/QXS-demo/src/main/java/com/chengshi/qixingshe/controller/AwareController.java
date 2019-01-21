package com.chengshi.qixingshe.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Aware;
import com.chengshi.qixingshe.service.IAwareService;
import com.chengshi.qixingshe.util.PageHelper;
import com.chengshi.qixingshe.util.constant.obj_status;
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
@Controller
@RequestMapping("/aware")
public class AwareController {

    @Autowired
    IAwareService awareService;

    @GetMapping("list")
    public String AwareList(Model model, @RequestParam Map<String, Object> params, HttpServletRequest request){
        model.addAttribute("fDate",params.get("fDate")==null?"":params.get("fDate"));
        model.addAttribute("tDate",params.get("tDate")==null?"":params.get("tDate"));
        model.addAttribute("title",params.get("title")==null?"":params.get("title"));
        model.addAttribute("status",params.get("status")==null?"":params.get("status"));
        model.addAttribute("url",PageHelper.getPageUrl(request));
        model.addAttribute("awareList",awareService.findAwarePages(new Query<>(params),new EntityWrapper<>()));
        return "/content/aware/aware-list";
    }

    @GetMapping("/add")
    public String AwareAdd(){
        return "/content/aware/aware-add";
    }

    @PostMapping
    @ResponseBody
    public Boolean awareAdd(@RequestBody Aware aware){
        return false;
    }

    @GetMapping("/edit")
    public String awareEdit(@PathVariable Integer id,Model model){
        model.addAttribute("aware",awareService.findAwareById(id));
        return "/content/aware/aware-edit";
    }

    @PutMapping("/edit")
    public Boolean awareEdit(@RequestBody Aware aware){
        return awareService.updateById(aware);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean awareDelete(@PathVariable Integer id){
        return awareService.deleteAware(id);
    }

    @PutMapping("/enable")
    @ResponseBody
    public Boolean awareEnable(@PathVariable Integer id){
        return awareService.changeAwareStatus(id, obj_status.STATUS_ENABLE);
    }

    @PutMapping("/disable")
    @ResponseBody
    public Boolean awareDisable(@PathVariable Integer id){
        return awareService.changeAwareStatus(id, obj_status.STATUS_DISABLE);
    }

    @DeleteMapping("/batchDelete")
    @ResponseBody
    public Boolean awareBatchDelete(List<Integer> ids){
        return awareService.deleteBatchIds(ids);
    }

}

