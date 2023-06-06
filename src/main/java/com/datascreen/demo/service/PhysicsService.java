package com.datascreen.demo.service;

import com.datascreen.demo.domain.Physics;
import com.datascreen.demo.mapper.PhysicsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PhysicsService {
    @Resource
    private PhysicsMapper physicsMapper;
    public List<Physics> list(){
        return physicsMapper.list();
    }

}
