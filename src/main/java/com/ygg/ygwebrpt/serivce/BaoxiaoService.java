package com.ygg.ygwebrpt.serivce;

import com.ygg.ygwebrpt.mapper.BaoxiaoMapper;
import com.ygg.ygwebrpt.model.Baoxiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaoxiaoService {

    @Autowired
    private BaoxiaoMapper baoxiaoMapper;
    public List<Baoxiao> baoxiaoList(){
        return baoxiaoMapper.baoxiaoList();
    }
}
