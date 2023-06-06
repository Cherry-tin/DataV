package com.datascreen.demo.controller;

import com.datascreen.demo.domain.Campus;
import com.datascreen.demo.service.CampusService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/campus")
public class CampusController {
    @Resource
    private CampusService campusService;
    @GetMapping("/list")//get查询
    public List<Campus> list(){
        List<Campus> list = campusService.list();
        return list;
    }
}
