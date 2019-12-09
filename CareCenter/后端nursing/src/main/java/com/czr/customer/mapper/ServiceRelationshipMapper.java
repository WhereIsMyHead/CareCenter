package com.czr.customer.mapper;

import com.czr.customer.model.ServiceRelationship;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ServiceRelationshipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceRelationship record);

    ServiceRelationship selectByPrimaryKey(Integer id);

    //按照各属性查询
    List<ServiceRelationship> selectByElement(ServiceRelationship serviceRelationship);

    int updateByPrimaryKey(ServiceRelationship record);

    void update(ServiceRelationship serviceRelationship);
}