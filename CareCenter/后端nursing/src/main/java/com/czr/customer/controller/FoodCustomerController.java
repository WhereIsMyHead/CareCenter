package com.czr.customer.controller;

import com.czr.customer.model.Food;
import com.czr.customer.model.FoodCustomer;
import com.czr.customer.service.FoodCustomerService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/food_customer")
public class FoodCustomerController {
    @Resource
    private FoodCustomerService foodCustomerService;

    //显示全部
    @RequestMapping("list/{currPage}")
    public PageInfo<FoodCustomer> list(@PathVariable Integer currPage){
        return this.foodCustomerService.list(currPage);
    }

    //查询
    @RequestMapping("selectspecify/{currPage}")
    public PageInfo<FoodCustomer> selectByName(@PathVariable Integer currPage,@RequestBody FoodCustomer foodCustomer)
    {
        return this.foodCustomerService.selectSpecify(currPage,foodCustomer);
    }

    @RequestMapping("selectall")
    public List<FoodCustomer> selectAll(){
        return this.foodCustomerService.selectAll();
    }

    @RequestMapping("update")
    public String Update(@RequestBody FoodCustomer foodCustomer)
    {
        foodCustomer.setUpdate_date(new Date());
        this.foodCustomerService.updateByPrimaryKey(foodCustomer);
        return "succ";
    }

    @RequestMapping("add")
    public String add(@RequestBody FoodCustomer foodCustomer){
        System.out.println(foodCustomer);
        this.foodCustomerService.add(foodCustomer);
        return "succ";
    }

    @RequestMapping("del/{id}")
    public String delFoodCustomer(@PathVariable Integer id){
        FoodCustomer foodCustomer=new FoodCustomer();
        foodCustomer.setId(id);
        foodCustomerService.delFoodCustomer(foodCustomer);
        return "succ";
    }
}
