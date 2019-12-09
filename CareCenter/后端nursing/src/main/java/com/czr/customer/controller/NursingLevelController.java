package com.czr.customer.controller;

import com.czr.customer.model.NursingLevel;
import com.czr.customer.service.NursingLevelService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/nursing_level")
public class NursingLevelController {
    @Resource
    private NursingLevelService nursingLevelService;

    @RequestMapping("selectall")
    public List<NursingLevel> selectAll(){
        return this.nursingLevelService.selectAll();
    }

    @RequestMapping("list/{currPage}")
    public PageInfo<NursingLevel> list(@PathVariable Integer currPage){
        return this.nursingLevelService.list(currPage);
    }

    @RequestMapping("searchbyname/{name}")
    public List<NursingLevel> searchByName(@PathVariable String name){
        NursingLevel level=new NursingLevel();
        level.setLevel_name(name);
        return this.nursingLevelService.selectSpecify(level);
    }

//    @RequestMapping("update")
//    public List<NursingLevel> testUpdate()
//    {
//        NursingLevel food=new Food();
//        food.setId(1);
//        food.setDel_flag(1);
//        food.setName("龟龟");
//        this.foodService.updateByPrimaryKey(food);
//        return this.foodService.selectAll();
//    }

    @RequestMapping("add")
    public String add(@RequestBody NursingLevel nursingLevel){
        System.out.println(nursingLevel);
        this.nursingLevelService.add(nursingLevel);
        return "succ";
    }

    @RequestMapping("del/{id}")
    public String delFood(@PathVariable Integer id){
        NursingLevel nursingLevel=new NursingLevel();
        nursingLevel.setId(id);
        this.nursingLevelService.delNursingLevel(nursingLevel);
        return "succ";
    }
}
