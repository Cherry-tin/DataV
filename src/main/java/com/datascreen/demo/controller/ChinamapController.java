package com.datascreen.demo.controller;

import com.datascreen.demo.domain.ChinaMap;
import com.datascreen.demo.service.ChinamapService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/chinamap")
public class ChinamapController {
    @Resource
    private ChinamapService chinamapService;
    @GetMapping("/list")//get查询
    public List<ChinaMap> list(){
        List<ChinaMap> list = chinamapService.list();
        return list;
    }
}

