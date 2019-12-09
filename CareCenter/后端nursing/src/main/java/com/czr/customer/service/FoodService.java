package com.czr.customer.service;

import com.czr.customer.model.FoodCustomer;
import com.github.pagehelper.PageInfo;
import com.czr.customer.model.Food;

import java.util.List;
//import org.springframework.data.domain.Page;

public interface FoodService {


    List<Food> selectAll();

    List<Food> selectSpecify(Food food);

    List<Food> selectById(List<Integer> id);

    void add(Food food);

    void updateByPrimaryKey(Food food);

//    void del(Integer id);
//
//    Food get(Integer id);
//
//    Food update(Food book);

    void delFood(Food food);


//    Page<Food> search(Integer currPage, String keyword);
//
//    PageInfo<Food> searchHighlight(Integer currPage, String keyword);
}
