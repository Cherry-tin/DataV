package com.datascreen.demo.service;

import com.datascreen.demo.domain.Gender;
import com.datascreen.demo.mapper.GenderMapper;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class GenderService {

    @Resource
    private GenderMapper genderMapper;
    public List<Gender> list(){
        return  genderMapper.list();
    }
}
