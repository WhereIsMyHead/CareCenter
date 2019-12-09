package com.czr.customer.service;

import com.czr.customer.model.CheckIn;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CheckInService {

    void add(CheckIn c);

//    List<CheckIn> selectAll();

    CheckIn selectByIdcard(String idcard);



    CheckIn selectById(Integer id);

    void delete(Integer id);

    void update(CheckIn checkIn);

    PageInfo<CheckIn> list(Integer currPage,CheckIn checkIn);

}
