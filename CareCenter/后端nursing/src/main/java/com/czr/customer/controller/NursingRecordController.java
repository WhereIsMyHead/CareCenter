package com.czr.customer.controller;

import com.czr.customer.model.FoodCustomer;
import com.czr.customer.model.NursingRecord;
import com.czr.customer.service.NursingRecordService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/nursing_record")
public class NursingRecordController {
    @Resource
    private NursingRecordService nursingRecordService;

    @RequestMapping("selectall")
    public List<NursingRecord> selectAll(){
        return this.nursingRecordService.selectAll();
    }

    @RequestMapping("list/{currPage}")
    public PageInfo<NursingRecord> list(@PathVariable Integer currPage){
        return this.nursingRecordService.list(currPage);
    }

    @RequestMapping("selectspecify/{currPage}")
    public PageInfo<NursingRecord> selectByName(@PathVariable Integer currPage, @RequestBody NursingRecord nursingRecord)
    {
        return this.nursingRecordService.selectSpecify(currPage,nursingRecord);
    }

//    @RequestMapping("update")
//    public List<NursingRecord> testUpdate()
//    {
//        NursingRecord food=new Food();
//        food.setId(1);
//        food.setDel_flag(1);
//        food.setName("龟龟");
//        this.foodService.updateByPrimaryKey(food);
//        return this.foodService.selectAll();
//    }

    @RequestMapping("add")
    public String add(@RequestBody NursingRecord nursingRecord){
        System.out.println(nursingRecord);
        this.nursingRecordService.add(nursingRecord);
        return "succ";
    }

    @RequestMapping("del/{id}")
    public String delFood(@PathVariable Integer id){
        NursingRecord nursingRecord=new NursingRecord();
        nursingRecord.setId(id);
        this.nursingRecordService.delNursingRecord(nursingRecord);
        return "succ";
    }
}
