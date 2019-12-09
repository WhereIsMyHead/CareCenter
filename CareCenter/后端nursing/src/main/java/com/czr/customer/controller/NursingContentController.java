package com.czr.customer.controller;

import com.czr.customer.model.NursingContent;
import com.czr.customer.model.NursingLevel;
import com.czr.customer.service.NursingContentService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/nursing_content")
public class NursingContentController {
    @Resource
    private NursingContentService nursingContentService;

    @RequestMapping("selectall")
    public List<NursingContent> selectAll(){
        return this.nursingContentService.selectAll();
    }

    @RequestMapping("list/{currPage}")
    public PageInfo<NursingContent> list(@PathVariable Integer currPage){
        return this.nursingContentService.list(currPage);
    }

    @RequestMapping("selectbylevel")
    public List<NursingContent> selectByLevel(@RequestBody NursingLevel nursingLevel){
        return this.nursingContentService.selectByLevel(nursingLevel);
    }

//    @RequestMapping("update")
//    public List<NursingContent> testUpdate()
//    {
//        NursingContent food=new Food();
//        food.setId(1);
//        food.setDel_flag(1);
//        food.setName("龟龟");
//        this.foodService.updateByPrimaryKey(food);
//        return this.foodService.selectAll();
//    }

    @RequestMapping("add")
    public String add(@RequestBody NursingContent nursingContent){
        System.out.println(nursingContent);
        this.nursingContentService.add(nursingContent);
        return "succ";
    }

    @RequestMapping("del")
    public String delFood(@RequestBody NursingContent nursingContent){
        this.nursingContentService.delNursingContent(nursingContent);
        return "succ";
    }
}
