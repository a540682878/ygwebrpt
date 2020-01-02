package com.ygg.ygwebrpt.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.ygg.ygwebrpt.model.Baoxiao;
import com.ygg.ygwebrpt.serivce.BaoxiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ExcelController {

    @Autowired
    private BaoxiaoService baoxiaoService;

    //财务报销XX表excel下载
    @RequestMapping("/ygs/baoxiao/download")
    public void export(HttpServletResponse response,
                       @RequestParam(name = "dates")Date dates) throws IOException {

        //将获取的数据封装成一个ArrayList<>

        Date time =new Date();
        time = dates;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(time);
        System.out.println(date);
        List<Baoxiao> baoxiaolist = new ArrayList<>();

        baoxiaolist = baoxiaoService.baoxiaoListByDate(date);


        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        String fileName = "财务XX报销表";
        Sheet sheet = new Sheet(1, 0, Baoxiao.class);
        //设置自适应宽度
        sheet.setAutoWidth(Boolean.TRUE);
        // 第一个 sheet 名称
        sheet.setSheetName("财务XX报销表");
        writer.write(baoxiaolist, sheet);
        //通知浏览器以附件的形式下载处理，设置返回头要注意文件名有中文
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1") + ".xlsx");
        writer.finish();
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        out.flush();
    }
}
