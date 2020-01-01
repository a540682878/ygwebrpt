package com.ygg.ygwebrpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ygg.ygwebrpt.model.Baoxiao;
import com.ygg.ygwebrpt.serivce.BaoxiaoService;
import com.ygg.ygwebrpt.serivce.LiaojianService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YgsController {

    @Autowired
    private BaoxiaoService baoxiaoService;
    @Autowired
    private LiaojianService liaojianService;


    @GetMapping("/ygs/{action}")
    public String ygs(@PathVariable(name = "action")String action,
                      Model model){
        if ("baoxiao".equals(action)){
            model.addAttribute("section","baoxiao");
            model.addAttribute("sectionName","财务XXX报表");
        }else if("liaojian".equals(action)){
            model.addAttribute("section","liaojian");
            model.addAttribute("sectionName","采购XXX报表");
        }

        return "Ygs";
    }

    @GetMapping("/ygs/baoxiao/list")
    public String baoxiaoList( @RequestParam(defaultValue = "1") Integer pn,
                               @RequestParam(defaultValue = "5") Integer pageSize,
                               Model model){
        //PN:(pageNum)的缩写，表示当前的页数；pageSize表示每页显示的数量
        Page p = PageHelper.startPage(pn, pageSize);
        //调用questionServices.list()方法,得到List<Question>
        //PageInfo<Question>内集合了所有的question信息即分页功能
        //navigatePages代表有有5个分页导航按钮
        PageInfo info = new PageInfo<>(baoxiaoService.baoxiaoList(), 5);

        model.addAttribute("baoxiao",info);

        return "CaiwuBaoxiao";
    }

    @GetMapping("/ygs/liaojian/list")
    public String liaojianList( @RequestParam(defaultValue = "1") Integer pn,
                               @RequestParam(defaultValue = "5") Integer pageSize,
                               Model model){
        Page p = PageHelper.startPage(pn, pageSize);
        PageInfo info = new PageInfo<>(liaojianService.liaojianList(), 5);

        model.addAttribute("liaojian",info);

        return "CaigouLiaojian";
    }





}
