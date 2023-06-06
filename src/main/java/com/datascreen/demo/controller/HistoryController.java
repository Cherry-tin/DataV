package com.datascreen.demo.controller;

import com.datascreen.demo.domain.History;
import com.datascreen.demo.service.HistoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/history")
public class HistoryController {
    @Resource
    private HistoryService historyService;
    @GetMapping("/list")//get查询
    public List<History> list(){
        List<History> list = historyService.list();
        return list;
    }
}
