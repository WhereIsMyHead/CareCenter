package com.czr.customer.controller;

import com.github.pagehelper.PageInfo;
import com.czr.customer.model.Food;
import com.czr.customer.service.FoodService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * restful风格: update/1,delete/1,get/1
 */

@CrossOrigin
@RestController
@RequestMapping("/food")
public class FoodController {

    @Resource
    private FoodService foodService;

    @RequestMapping("selectall")
    public List<Food> selectAll(){
       return this.foodService.selectAll();
    }

    @RequestMapping("update")
    public String update(@RequestBody Food food)
    {
        this.foodService.updateByPrimaryKey(food);
        return "succ";
    }

    @RequestMapping("selectsupply/{day}/{supply}")
    public List<Food> selectSupply(@PathVariable Integer day,@PathVariable Integer supply){
        Food food = new Food();
        food.setSupply_type(supply);
        food.setDel_flag(0);
        switch(day)
        {
            case 1:
                food.setMon_flag(1);
                break;
            case 2:
                food.setTue_flag(1);
                break;
            case 3:
                food.setWed_flag(1);
                break;
            case 4:
                food.setThu_flag(1);
                break;
            case 5:
                food.setFri_flag(1);
                break;
            case 6:
                food.setSat_flag(1);
                break;
            case 7:
                food.setSun_flag(1);
                break;
        }
        return this.foodService.selectSpecify(food);
    }

    @RequestMapping("delbyday/{id}/{day}")
    public String delByDay(@PathVariable Integer id,@PathVariable Integer day){
        Food food = new Food();
        food.setId(id);
        switch(day)
        {
            case 1:
                food.setMon_flag(0);
                break;
            case 2:
                food.setTue_flag(0);
                break;
            case 3:
                food.setWed_flag(0);
                break;
            case 4:
                food.setThu_flag(0);
                break;
            case 5:
                food.setFri_flag(0);
                break;
            case 6:
                food.setSat_flag(0);
                break;
            case 7:
                food.setSun_flag(0);
                break;
        }
        this.foodService.updateByPrimaryKey(food);
        return "succ";
    }

    @RequestMapping("add")
    public String add(@RequestBody Food food){
        System.out.println(food);
        this.foodService.add(food);
        return "succ";
    }

//    @RequestMapping("del/{id}")
//    public String del(@PathVariable  Integer id){
//        bookService.del(id);
//        return "succ";
//    }
//
//    @RequestMapping("get/{id}")
//    public Food get(@PathVariable Integer id){
//        return bookService.get(id);
//    }
//
//    @RequestMapping("update")
//    public String update(@RequestBody Food book){
//        bookService.update(book);
//        return "succ";
//    }

    @RequestMapping("del/{id}")
    public String delFood(@PathVariable Integer id){
        Food food=new Food();
        food.setId(id);
        foodService.delFood(food);
        return "succ";
    }

//    @RequestMapping("search/{currPage}")
//    public PageInfo<Food> search(@PathVariable Integer currPage, @RequestBody Map<String,Object> form){
//        Map<String,Object> hm  = (Map)form.get("form");
//        String keyword = (String)hm.get("keyword");
//        System.out.println(keyword);
//        return foodService.searchHighlight(currPage,keyword);
//    }

}