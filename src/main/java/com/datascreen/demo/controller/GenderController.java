package com.datascreen.demo.controller;

import com.datascreen.demo.domain.Gender;
import com.datascreen.demo.service.GenderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/gender")
public class GenderController {
    @Resource
    private GenderService genderService;
    @GetMapping("/list")//get查询
    public List<Gender> list(){
        List<Gender> list = genderService.list();
        return list;
    }
}
