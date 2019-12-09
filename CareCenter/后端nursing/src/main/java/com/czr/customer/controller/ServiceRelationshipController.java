package com.czr.customer.controller;

import com.czr.customer.VO.WorkerVO;
import com.czr.customer.model.ServiceRelationship;
import com.czr.customer.service.RelationshipService;
import com.github.pagehelper.PageInfo;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/serviceRelationship")
public class ServiceRelationshipController {

	@Resource
	private RelationshipService relationshipService;

	/*@InitBinder
	protected void initBinder HttpServletRequest request, Servlet*/

	@RequestMapping("/insert")
	public boolean insert(@RequestBody ServiceRelationship serviceRelationship){
		System.out.println("[insert]" + serviceRelationship.toString());
		return relationshipService.insert(serviceRelationship);
	}

	@RequestMapping("/delete")
	public boolean delete(@RequestBody ServiceRelationship serviceRelationship){
		System.out.println("[delete]" + serviceRelationship.toString());
		return relationshipService.delete(serviceRelationship);
	}

	@RequestMapping("/update")
	public boolean update(@RequestBody WorkerVO workerVO){
		System.out.println(workerVO.toString());
		return relationshipService.update(workerVO);
	}

	@RequestMapping("/search/{page}")
	public PageInfo<ServiceRelationship> search(@PathVariable Integer page, @RequestBody ServiceRelationship serviceRelationship){
		System.out.println("[search]" + serviceRelationship.toString());
		return relationshipService.search(page, serviceRelationship);
	}
	@RequestMapping("/find/{page}")
	public PageInfo<WorkerVO> find(@PathVariable Integer page, @RequestBody ServiceRelationship serviceRelationship){
		return relationshipService.find(page, serviceRelationship);
	}

	@RequestMapping("/find1/{page}")
	public PageInfo<WorkerVO> find1(@PathVariable Integer page, @RequestBody WorkerVO workerVO){
		System.out.println(workerVO.toString());
		return relationshipService.find1(page, workerVO);
	}


}
