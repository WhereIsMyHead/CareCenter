package com.czr.customer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.czr.customer.mapper.FoodCustomerMapper;
import com.czr.customer.model.FoodCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FoodCustomerServiceImpl implements FoodCustomerService {
    @Autowired
    private FoodCustomerMapper foodCustomerMapper;

    public List<FoodCustomer> selectAll(){
        return foodCustomerMapper.selectAll();
    }

    @Override
    public PageInfo<FoodCustomer> selectSpecify(Integer currPage,FoodCustomer foodCustomer)
    {
        if(currPage == null) currPage = 1;
        //设置从第几页查询N条
        PageHelper.startPage(currPage, 10);
        //分页查询
        PageInfo<FoodCustomer> pageInfo = new PageInfo<>(foodCustomerMapper.selectSpecify(foodCustomer));
        return pageInfo;
    }

    @Override
    public PageInfo<FoodCustomer> list(Integer currPage) {
        if(currPage == null) currPage = 1;
        //设置从第几页查询N条
        PageHelper.startPage(currPage, 10);
        //分页查询
        PageInfo<FoodCustomer> pageInfo = new PageInfo<>(foodCustomerMapper.selectAll());
        return pageInfo;
    }
    /**
     *  新增
     * @param foodCustomer
     */
    @Override
    public void add(FoodCustomer foodCustomer) {
        foodCustomer.setCreate_date(new Date());
        foodCustomer.setUpdate_date(new Date());
        this.foodCustomerMapper.insert(foodCustomer);
        System.out.println(foodCustomer);
        //保存文档
//        bookRepository.save(book);

    }

    @Override
    public void updateByPrimaryKey(FoodCustomer foodCustomer)
    {
        foodCustomer.setUpdate_date(new Date());
        this.foodCustomerMapper.updateByPrimaryKey(foodCustomer);
    }

    @Override
    @CachePut(value="foodCustomer",key="#foodCustomer.id")
    public void delFoodCustomer(FoodCustomer foodCustomer) {
        foodCustomerMapper.delFoodCustomer(foodCustomer);
//        return foodMapper.selectByPrimaryKey(book.getId());
    }
}
