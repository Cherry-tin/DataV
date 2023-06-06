package com.datascreen.demo.controller;

import com.datascreen.demo.domain.Physics;
import com.datascreen.demo.service.PhysicsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/physics")
public class PhysicsController {
    @Resource
    private PhysicsService physicsService;
    @GetMapping("/list")//get查询
    public List<Physics> list(){
        List<Physics> list = physicsService.list();
        return list;
    }
}
