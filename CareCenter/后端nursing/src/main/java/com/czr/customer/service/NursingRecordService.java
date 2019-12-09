package com.czr.customer.service;

import com.czr.customer.model.NursingRecord;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface NursingRecordService {
    List<NursingRecord> selectAll();

    PageInfo<NursingRecord> list(Integer currPage);

    PageInfo<NursingRecord> selectSpecify(Integer currPage, NursingRecord nursingRecord);

    List<NursingRecord> selectSpecify(NursingRecord nursingRecord);

    void add(NursingRecord nursingRecord);

    void updateByPrimaryKey(NursingRecord nursingRecord);

    void delNursingRecord(NursingRecord nursingRecord);
}
