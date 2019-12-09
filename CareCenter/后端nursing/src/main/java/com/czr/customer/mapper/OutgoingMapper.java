package com.czr.customer.mapper;

import com.czr.customer.VO.OutgoingVO;
import com.czr.customer.model.Outgoing;
import java.util.List;

public interface OutgoingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Outgoing record);

    Outgoing selectByPrimaryKey(Integer id);

    List<Outgoing> selectAll();

    int updateByPrimaryKey(Outgoing record);

    List<Outgoing> selectByIsDelete(Outgoing outgoing);
}