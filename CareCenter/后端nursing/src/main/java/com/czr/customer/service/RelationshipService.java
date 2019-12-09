package com.czr.customer.service;


import com.czr.customer.VO.WorkerVO;
import com.czr.customer.model.ServiceRelationship;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RelationshipService {

	boolean insert(ServiceRelationship serviceRelationship);

	boolean delete(ServiceRelationship serviceRelationship);

	boolean update(WorkerVO workerVO);

	PageInfo<ServiceRelationship> search(Integer page, ServiceRelationship serviceRelationship);

	PageInfo<WorkerVO> find(Integer currPage, ServiceRelationship serviceRelationship);

	PageInfo<WorkerVO> find1(Integer currPage, WorkerVO workerVO);
}
