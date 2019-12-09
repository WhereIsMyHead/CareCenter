package com.czr.customer.service;

import com.czr.customer.mapper.NursingRecordMapper;
import com.czr.customer.model.FoodCustomer;
import com.czr.customer.model.NursingRecord;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NursingRecordServiceImpl implements NursingRecordService {

    @Autowired
    private NursingRecordMapper nursingRecordMapper;

    public PageInfo<NursingRecord> selectSpecify(Integer currPage, NursingRecord nursingRecord)
    {
        if(currPage == null) currPage = 1;
        //设置从第几页查询N条
        PageHelper.startPage(currPage, 5);
        //分页查询
        PageInfo<NursingRecord> pageInfo = new PageInfo<>(nursingRecordMapper.selectSpecify(nursingRecord));
        return pageInfo;
    }

    public List<NursingRecord> selectAll() {
        return nursingRecordMapper.selectAll();
    }

    public List<NursingRecord> selectSpecify(NursingRecord nursingRecord) {
        return nursingRecordMapper.selectSpecify(nursingRecord);
    }

    @Override
    public PageInfo<NursingRecord> list(Integer currPage) {
        if(currPage == null) currPage = 1;
        //设置从第几页查询N条
        PageHelper.startPage(currPage, 5);
        //分页查询
        PageInfo<NursingRecord> pageInfo = new PageInfo<>(nursingRecordMapper.selectAll());
        return pageInfo;
    }

    @Override
    public void add(NursingRecord nursingRecord) {
        this.nursingRecordMapper.insert(nursingRecord);
        System.out.println(nursingRecord);
    }

    @Override
    public void updateByPrimaryKey(NursingRecord nursingRecord) {
        this.nursingRecordMapper.updateByPrimaryKey(nursingRecord);
    }

    @Override
    @CachePut(value = "nursingRecord", key = "#nursingRecord.id")
    public void delNursingRecord(NursingRecord nursingRecord) {
        this.nursingRecordMapper.delNursingRecord(nursingRecord);
    }
}