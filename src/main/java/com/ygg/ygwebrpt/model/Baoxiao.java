package com.ygg.ygwebrpt.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Builder;
import lombok.Data;

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

}
