package com.datascreen.demo.service;

import com.datascreen.demo.domain.Campus;
import com.datascreen.demo.mapper.CampusMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CampusService {
    @Resource
    private CampusMapper campusMapper;
    public List<Campus> list(){
        return campusMapper.list();
    }
}
