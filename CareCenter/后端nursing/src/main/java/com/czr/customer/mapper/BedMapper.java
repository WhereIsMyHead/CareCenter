package com.czr.customer.mapper;


import com.czr.customer.model.Bed;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bed record);

    Bed selectByPrimaryKey(Integer id);

    //按照各属性查询
    List<Bed> selectByElement(Bed bed);

    int updateByPrimaryKey(Bed record);
}