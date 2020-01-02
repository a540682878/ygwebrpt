package com.ygg.ygwebrpt.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@Builder
public class Baoxiao extends BaseRowModel {
    @ExcelProperty(value = "id",index = 0)
    private Integer id;
    @ExcelProperty(value = "money",index = 1)
    private String money;
    @ExcelProperty(value = "姓名",index = 2)
    private String name;
    @ExcelProperty(value = "年龄",index = 3)
    private Integer age;
    @ExcelProperty(value = "日期",index = 4)
    private Date date;
}
