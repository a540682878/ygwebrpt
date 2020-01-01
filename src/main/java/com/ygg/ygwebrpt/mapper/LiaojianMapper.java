package com.ygg.ygwebrpt.mapper;

import com.ygg.ygwebrpt.model.Liaojian;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LiaojianMapper {
    @Select("select * from liaojian")
    public List<Liaojian> liaojianList();
}
