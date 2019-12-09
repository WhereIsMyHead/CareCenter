package com.czr.customer.service;

import com.czr.customer.mapper.NursingLevelMapper;
import com.czr.customer.model.NursingLevel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NursingLevelServiceImpl implements NursingLevelService {

    @Autowired
    private NursingLevelMapper nursingLevelMapper;
    public List<NursingLevel> selectAll() {
        return nursingLevelMapper.selectAll();
    }

    public List<NursingLevel> selectSpecify(NursingLevel nursingLevel){
        return nursingLevelMapper.selectSpecify(nursingLevel);
    }

    @Override
    public PageInfo<NursingLevel> list(Integer currPage) {
        if(currPage == null) currPage = 1;
        //设置从第几页查询N条
        PageHelper.startPage(currPage, 10);
        //分页查询
        PageInfo<NursingLevel> pageInfo = new PageInfo<>(nursingLevelMapper.selectAll());
        return pageInfo;
    }

    @Override
    public  void add(NursingLevel nursingLevel){
        nursingLevel.setCreate_date(new Date());
        nursingLevel.setUpdate_date(new Date());
        this.nursingLevelMapper.insert(nursingLevel);
        System.out.println(nursingLevel);
    }

    @Override
    public void updateByPrimaryKey(NursingLevel nursingLevel){
        nursingLevel.setUpdate_date(new Date());
        this.nursingLevelMapper.updateByPrimaryKey(nursingLevel);
    }

    @Override
    @CachePut(value="nursingLevel",key="#nursingLevel.id")
    public void delNursingLevel(NursingLevel nursingLevel){
        this.nursingLevelMapper.delNursingLevel(nursingLevel);
    }
}