package com.czr.customer.mapper;

import com.czr.customer.model.CheckIn;
import java.util.List;

public interface CheckInMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckIn record);

    CheckIn selectByPrimaryKey(Integer id);

    List<CheckIn> selectAll();

    int updateByPrimaryKey(CheckIn record);

    CheckIn selectByIdcard(String idcard);

    List<CheckIn> selectByIsDelete(CheckIn checkIn);
}