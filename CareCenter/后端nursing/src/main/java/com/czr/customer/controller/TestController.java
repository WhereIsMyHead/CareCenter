package com.czr.customer.controller;

import com.czr.customer.mapper.CheckInMapper;
import com.czr.customer.model.CheckIn;
import com.czr.customer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("demo")
    public List<CheckIn> demo(){
        return testService.selectAll();
    }

}
