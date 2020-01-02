package com.ygg.ygwebrpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ygg.ygwebrpt.model.Baoxiao;
import com.ygg.ygwebrpt.serivce.BaoxiaoService;
import com.ygg.ygwebrpt.serivce.LiaojianService;
import com.ygg.ygwebrpt.until.DateConverter;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class YgsController {

    @Autowired
    private BaoxiaoService baoxiaoService;
    @Autowired
    private LiaojianService liaojianService;

    //到ygs页面
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

    //报销报表
    @RequestMapping("/ygs/baoxiao/list")
    public String baoxiaoList( @RequestParam(defaultValue = "1") Integer pn,
                               @RequestParam(defaultValue = "5") Integer pageSize,
                               @RequestParam(name = "dates")Date dates,
                               Model model){
        System.out.println("date = "+dates);

        //日期格式转换
        Date time =new Date();
        time = dates;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(time);

        //分页及传资料到页面
        Page p = PageHelper.startPage(pn, pageSize);
        PageInfo info = new PageInfo<>(baoxiaoService.baoxiaoListByDate(date), 5);
        model.addAttribute("baoxiao",info);

        return "CaiwuBaoxiao";
    }

    //料件报表
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
