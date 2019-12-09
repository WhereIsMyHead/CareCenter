package com.czr.customer.service;

import com.czr.customer.model.NursingLevel;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface NursingLevelService {
    List<NursingLevel> selectAll();

    PageInfo<NursingLevel> list(Integer currPage);

    List<NursingLevel> selectSpecify(NursingLevel nursingLevel);

    void add(NursingLevel nursingLevel);

    void updateByPrimaryKey(NursingLevel nursingLevel);

    void delNursingLevel(NursingLevel nursingLevel);
}

