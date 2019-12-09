package com.czr.customer.service;

import com.czr.customer.model.NursingContent;
import com.czr.customer.model.NursingLevel;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface NursingContentService {

    List<NursingContent> selectAll();

    PageInfo<NursingContent> list(Integer currPage);

    List<NursingContent> selectSpecify(NursingContent nursingContent);

    List<NursingContent> selectByLevel(NursingLevel nursingLevel);

    void add(NursingContent nursingContent);

    void updateByPrimaryKey(NursingContent nursingContent);

//    void del(Integer id);
//
//    Food get(Integer id);
//
//    Food update(Food book);

    void delNursingContent(NursingContent nursingContent);
}
