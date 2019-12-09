package com.czr.customer.service;

import com.czr.customer.mapper.NursingContentMapper;
import com.czr.customer.model.NursingContent;
import com.czr.customer.model.NursingLevel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NursingContentServiceImpl implements NursingContentService {

    @Autowired
    private NursingContentMapper nursingContentMapper;
    public List<NursingContent> selectAll() {
        return nursingContentMapper.selectAll();
    }

    public List<NursingContent> selectSpecify(NursingContent nursingContent){
        return nursingContentMapper.selectSpecify(nursingContent);
    }

    public List<NursingContent> selectByLevel(NursingLevel nursingLevel){
        String content=nursingLevel.getContent();
        String[] content_id=content.split(",");
        List<NursingContent> res=new ArrayList<>();
        NursingContent temp=new NursingContent();
        temp.setDel_flag(0);
        for(int i=0;i<content_id.length;i++)
        {
            temp.setId(Integer.parseInt( content_id[0] ));
            res.addAll(nursingContentMapper.selectSpecify(temp));
        }
        return res;
    }

    @Override
    public PageInfo<NursingContent> list(Integer currPage) {
        if(currPage == null) currPage = 1;
        //设置从第几页查询N条
        PageHelper.startPage(currPage, 10);
        //分页查询
        PageInfo<NursingContent> pageInfo = new PageInfo<>(nursingContentMapper.selectAll());
        return pageInfo;
    }
    @Override
    public  void add(NursingContent nursingContent){
        this.nursingContentMapper.insert(nursingContent);
        System.out.println(nursingContent);
    }

    @Override
    public void updateByPrimaryKey(NursingContent nursingContent){
        this.nursingContentMapper.updateByPrimaryKey(nursingContent);
    }

    @Override
    @CachePut(value="nursingContent",key="#nursingContent.id")
    public void delNursingContent(NursingContent nursingContent){
        this.nursingContentMapper.delNursingContent(nursingContent);
    }
}
