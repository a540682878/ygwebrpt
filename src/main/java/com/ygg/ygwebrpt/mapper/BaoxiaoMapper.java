package com.ygg.ygwebrpt.mapper;

import com.ygg.ygwebrpt.model.Baoxiao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface BaoxiaoMapper {

    @Select("select id as ID, name as Name, money as Money, age as Age from baoxiao")
    public List<Baoxiao> baoxiaoList();

    @Select("select * from baoxiao where date=#{date}")
    public List<Baoxiao> baoxiaolistByDate(@Param("date") String date);
}
