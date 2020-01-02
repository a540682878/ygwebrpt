package com.ygg.ygwebrpt.serivce;

import com.ygg.ygwebrpt.mapper.BaoxiaoMapper;
import com.ygg.ygwebrpt.model.Baoxiao;
import com.ygg.ygwebrpt.until.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BaoxiaoService {

    @Autowired
    private BaoxiaoMapper baoxiaoMapper;

    public List<Baoxiao> baoxiaoList(){
        return baoxiaoMapper.baoxiaoList();
    }

    public List<Baoxiao> baoxiaoListByDate(String date){

        return baoxiaoMapper.baoxiaolistByDate(date);
    }
}
