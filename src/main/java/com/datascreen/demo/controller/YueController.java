package com.datascreen.demo.controller;

import com.datascreen.demo.domain.Yue;
import com.datascreen.demo.service.YueService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/guangdong")
public class YueController {
    @Resource
    private YueService yueService;
    @GetMapping("/list")//get查询
    public List<Yue> list(){
        List<Yue> list = yueService.list();
        return list;
    }
}
