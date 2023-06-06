package com.datascreen.demo.service;

import com.datascreen.demo.domain.Yue;
import com.datascreen.demo.mapper.YueMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class YueService {
    @Resource
    private YueMapper yueMapper;
    public List<Yue> list(){
        return yueMapper.list();
    }
}
