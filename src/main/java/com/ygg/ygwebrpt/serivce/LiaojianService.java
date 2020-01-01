package com.ygg.ygwebrpt.serivce;

import com.ygg.ygwebrpt.mapper.LiaojianMapper;
import com.ygg.ygwebrpt.model.Liaojian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiaojianService {

    @Autowired
    private LiaojianMapper liaojianMapper;

    public List<Liaojian> liaojianList(){
        return liaojianMapper.liaojianList();
    }
}
