package com.czr.customer.service;

import com.czr.customer.VO.OutgoingVO;
import com.czr.customer.model.Outgoing;
import com.github.pagehelper.PageInfo;

public interface OutgoingService {

    void add(Outgoing outgoing);

    void update(Outgoing outgoing);

    void delete(Integer id);

//    OutgoingVO getVO(Integer id);

    Outgoing get(Integer id);

    PageInfo<OutgoingVO> list(Integer currPage,Outgoing outgoing);
}
