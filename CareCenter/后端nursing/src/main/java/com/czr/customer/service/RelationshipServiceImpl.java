package com.czr.customer.service;

import com.czr.customer.VO.WorkerVO;
import com.czr.customer.mapper.CheckInMapper;
import com.czr.customer.mapper.ServiceRelationshipMapper;
import com.czr.customer.mapper.UserMapper;
import com.czr.customer.model.CheckIn;
import com.czr.customer.model.ServiceRelationship;
import com.czr.customer.model.User;
import com.czr.customer.util.Define;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RelationshipServiceImpl implements RelationshipService{

	@Autowired
	private ServiceRelationshipMapper serviceRelationshipMapper;

	@Autowired
	private CheckInMapper checkInMapper;

	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean insert(ServiceRelationship serviceRelationship) {
		serviceRelationshipMapper.insert(serviceRelationship);
		return true;
	}

	@Override
	public boolean delete(ServiceRelationship serviceRelationship) {
		ServiceRelationship serviceRelationship1 = new ServiceRelationship(serviceRelationship);
		List<ServiceRelationship> serviceRelationships = serviceRelationshipMapper.selectByElement(serviceRelationship1);
		if(serviceRelationships.size() <= 0)
			return false;
		for(ServiceRelationship s:serviceRelationships){
			s.setIsDeleted(1);
			serviceRelationshipMapper.updateByPrimaryKey(s);
		}
		return true;

	}

	@Override
	public boolean update(WorkerVO workerVO) {
		ServiceRelationship serviceRelationship=VOto1(workerVO);
		serviceRelationship.setUpdateTime(new Date());
		serviceRelationshipMapper.update(serviceRelationship);
		return true;
	}

	@Override
	public PageInfo<ServiceRelationship> search(Integer page, ServiceRelationship serviceRelationship) {
		ServiceRelationship serviceRelationship1 = new ServiceRelationship(serviceRelationship);
		if(page == null) page = 1;
		//设置从第几页查询N条
		PageHelper.startPage(page, 10);
		//分页查询
		PageInfo<ServiceRelationship> pageInfo = new PageInfo<>(serviceRelationshipMapper.selectByElement(serviceRelationship1));
		return pageInfo;
	}

	private WorkerVO toVO(ServiceRelationship serviceRelationship){
		WorkerVO vo=new WorkerVO();
		vo.setCreateBy(serviceRelationship.getCreateBy());
		vo.setCreateTime(serviceRelationship.getCreateTime());
		vo.setCustomerId(serviceRelationship.getCustomerId());
		vo.setId(serviceRelationship.getId());
		vo.setIsDeleted(serviceRelationship.getIsDeleted());
		vo.setUpdateBy(serviceRelationship.getUpdateBy());
		vo.setUpdateTime(serviceRelationship.getUpdateTime());

		CheckIn checkIn=checkInMapper.selectByPrimaryKey(serviceRelationship.getCustomerId());
		vo.setCustomerName(checkIn.getCustomerName());

		User user;
		if (null != serviceRelationship.getDoctorId()){
			user=userMapper.selectByPrimaryKey(serviceRelationship.getDoctorId());
			vo.setDoctorName(user.getNickname());
			vo.setDoctorId(user.getId());
		}
		if(null != serviceRelationship.getNurseId()) {
			user = userMapper.selectByPrimaryKey(serviceRelationship.getNurseId());
			vo.setNurseName(user.getNickname());
			vo.setNurseId(user.getId());
		}
		if(null != serviceRelationship.getCareWorkerId()) {
			user = userMapper.selectByPrimaryKey(serviceRelationship.getCareWorkerId());
			vo.setCareWorkerName(user.getNickname());
			vo.setCareWorkerId(user.getId());
		}
		return vo;
	}

	//员工name转id
	private List<ServiceRelationship> VOto(WorkerVO workerVO){

		List<ServiceRelationship> serviceRelationshipList = new ArrayList<>();

		CheckIn checkIn=new CheckIn();
		checkIn.setCustomerName(workerVO.getCustomerName());
		List<CheckIn> checkInList = checkInMapper.selectByIsDelete(checkIn);
		for(CheckIn c:checkInList) {

			ServiceRelationship serviceRelationship=new ServiceRelationship();
			serviceRelationship.setCustomerId(c.getId());
			User user = new User();
				if (null != workerVO.getDoctorName() && !workerVO.getDoctorName().equals("")) {
					user.setNickname(workerVO.getDoctorName());
					serviceRelationship.setDoctorId(userMapper.selectByElement(user).get(0).getId());
				}

				if (null!=workerVO.getNurseName() && !workerVO.getNurseName().equals("")) {
					user.setNickname(workerVO.getNurseName());
					serviceRelationship.setNurseId(userMapper.selectByElement(user).get(0).getId());
				}

				if (null != workerVO.getCareWorkerName() && !workerVO.getCareWorkerName().equals("")) {
					user.setNickname(workerVO.getCareWorkerName());
					serviceRelationship.setCareWorkerId(userMapper.selectByElement(user).get(0).getId());
				}

			serviceRelationship.setCreateBy(workerVO.getCreateBy());
			serviceRelationship.setCreateTime(workerVO.getCreateTime());
			serviceRelationship.setUpdateBy(workerVO.getUpdateBy());
			serviceRelationship.setUpdateTime(workerVO.getUpdateTime());

			serviceRelationship.setId(workerVO.getId());
			serviceRelationship.setIsDeleted(workerVO.getIsDeleted());
			serviceRelationshipList.add(serviceRelationship);
		}
		return serviceRelationshipList;
	}

	//员工name转id
	private ServiceRelationship VOto1(WorkerVO workerVO){

		List<ServiceRelationship> serviceRelationshipList = new ArrayList<>();

		CheckIn checkIn=new CheckIn();
		checkIn.setId(workerVO.getCustomerId());
		checkIn = checkInMapper.selectByPrimaryKey(checkIn.getId());

		ServiceRelationship serviceRelationship=new ServiceRelationship();
		serviceRelationship.setCustomerId(checkIn.getId());
		User user = new User();
		if (null != workerVO.getDoctorName() && !workerVO.getDoctorName().equals("")) {
			user.setNickname(workerVO.getDoctorName());
			serviceRelationship.setDoctorId(userMapper.selectByElement(user).get(0).getId());
		}
		if (null!=workerVO.getNurseName() && !workerVO.getNurseName().equals("")) {
			user.setNickname(workerVO.getNurseName());
			serviceRelationship.setNurseId(userMapper.selectByElement(user).get(0).getId());
		}

		if (null != workerVO.getCareWorkerName() && !workerVO.getCareWorkerName().equals("")) {
			user.setNickname(workerVO.getCareWorkerName());
			serviceRelationship.setCareWorkerId(userMapper.selectByElement(user).get(0).getId());
		}

		serviceRelationship.setCreateBy(workerVO.getCreateBy());
		serviceRelationship.setCreateTime(workerVO.getCreateTime());
		serviceRelationship.setUpdateBy(workerVO.getUpdateBy());
		serviceRelationship.setUpdateTime(workerVO.getUpdateTime());

		serviceRelationship.setId(workerVO.getId());
		serviceRelationship.setIsDeleted(workerVO.getIsDeleted());
		serviceRelationshipList.add(serviceRelationship);

		return serviceRelationship;
	}
	@Override
	public PageInfo<WorkerVO> find(Integer currPage, ServiceRelationship serviceRelationship) {
		if(currPage == 0) currPage = 1;
		//设置从第几页查询N条
		PageHelper.startPage(currPage, Define.PAGE_SIZE);
		//分页查询

		List<ServiceRelationship> serviceRelationshipList=serviceRelationshipMapper.selectByElement(serviceRelationship);
		PageInfo pageInfo = new PageInfo<>(serviceRelationshipList);

//        转换成VO之后，分页total大小与实际不符的处理
		List<WorkerVO> workerVOS=new ArrayList<>();
		for(int i=0;i<serviceRelationshipList.size();++i){
			workerVOS.add(toVO(serviceRelationshipList.get(i)));
		}
		pageInfo.setList(workerVOS);
		return pageInfo;
	}

	@Override
	public PageInfo<WorkerVO> find1(Integer currPage, WorkerVO workerVO) {
		if(currPage == 0) currPage = 1;
		//设置从第几页查询N条
		PageHelper.startPage(currPage, Define.PAGE_SIZE);
		//分页查询
		List<ServiceRelationship> serviceRelationships = VOto(workerVO);
		List<ServiceRelationship> serviceRelationshipList = new ArrayList<>();
		for(ServiceRelationship s:serviceRelationships) {
			 serviceRelationshipList.add(serviceRelationshipMapper.selectByElement(s).get(0));
		}
		PageInfo pageInfo = new PageInfo<>(serviceRelationshipList);

//        转换成VO之后，分页total大小与实际不符的处理
		List<WorkerVO> workerVOS=new ArrayList<>();
		for(int i=0;i<serviceRelationshipList.size();++i){
			workerVOS.add(toVO(serviceRelationshipList.get(i)));
		}
		pageInfo.setList(workerVOS);
		return pageInfo;
	}
}
