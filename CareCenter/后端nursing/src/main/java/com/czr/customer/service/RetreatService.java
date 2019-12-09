package com.czr.customer.service;

import com.czr.customer.VO.RetreatVO;
import com.czr.customer.model.Retreat;
import com.github.pagehelper.PageInfo;



public interface RetreatService {

    void add(Retreat retreat);

    void update(Retreat retreat);

    void delete(Integer id);

    void setAgree(Retreat retreat);

    Retreat get(Integer id);

    PageInfo<RetreatVO> list(Integer currPage,Retreat retreat);

}
