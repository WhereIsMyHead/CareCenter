package com.czr.customer.mapper;

import com.czr.customer.model.Retreat;
import java.util.List;

public interface RetreatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Retreat record);

    Retreat selectByPrimaryKey(Integer id);

    List<Retreat> selectAll();

    int updateByPrimaryKey(Retreat record);

    List<Retreat> selectByIsDelete(Retreat retreat);

    void agree(Retreat retreat);
}