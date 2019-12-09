package com.czr.customer.service;

import com.czr.customer.model.FoodCustomer;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface FoodCustomerService {
    List<FoodCustomer> selectAll();

    PageInfo<FoodCustomer> list(Integer currPage);

    PageInfo<FoodCustomer> selectSpecify(Integer currPage, FoodCustomer foodCustomer);

    void add(FoodCustomer foodCustomer);

    void updateByPrimaryKey(FoodCustomer foodCustomer);

//    void del(Integer id);
//
//    Food get(Integer id);
//
//    Food update(Food book);

    void delFoodCustomer(FoodCustomer foodCustomer);
}
