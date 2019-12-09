package com.czr.customer.service;

import com.czr.customer.mapper.BedMapper;
import com.czr.customer.mapper.CheckInMapper;
import com.czr.customer.mapper.FoodCustomerMapper;
import com.czr.customer.mapper.ServiceRelationshipMapper;
import com.czr.customer.model.Bed;
import com.czr.customer.model.CheckIn;
import com.czr.customer.model.FoodCustomer;
import com.czr.customer.model.ServiceRelationship;
import com.czr.customer.util.Define;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    CheckInMapper checkInMapper;

    @Autowired
    BedMapper bedMapper;

    @Autowired
    ServiceRelationshipMapper serviceRelationshipMapper;

    @Autowired
    FoodCustomerMapper foodCustomerMapper;

    //    按身份证查询
    @Override
    public CheckIn selectByIdcard(String idcard) {
        return checkInMapper.selectByIdcard(idcard);
    }

//    查询所有未删除记录
//    @Override
//    public List<CheckIn> selectAll() {
//        return checkInMapper.selectByIsDelete(0);
//    }

    @Override
    public PageInfo<CheckIn> list(Integer currPage,CheckIn checkIn) {
        if(currPage == 0) currPage = 1;
        //设置从第几页查询N条
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        //分页查询

        PageInfo<CheckIn> pageInfo = new PageInfo<>(checkInMapper.selectByIsDelete(checkIn));
        return pageInfo;
    }

    //    添加入住记录-不完整
    @Override
    public void add(CheckIn checkIn) {
        checkIn.setCreateTime(new Date());
        checkIn.setUpdateTime(new Date());
        checkIn.setIsDeleted(0);
        checkIn.setRecordId(checkIn.getId());
        checkIn.setBuildingId(1);
        checkInMapper.insert(checkIn);

        //床位表改有人
        Bed bed = new Bed();
        System.out.println("-----------------------------");
        System.out.println(checkIn.getBedId() + checkIn.getRoomNumber());
        bed.setName(checkIn.getBedId().toString());
        bed.setRoomNumber(checkIn.getRoomNumber());
        bed=bedMapper.selectByElement(bed).get(0);
        bed.setBedStatus("1");
        bedMapper.updateByPrimaryKey(bed);

        //新增服务关系记录
        ServiceRelationship serviceRelationship =  new ServiceRelationship();
        serviceRelationship.setCustomerId(checkIn.getId());
        serviceRelationship.setCreateTime(new Date());
        serviceRelationship.setCreateBy(checkIn.getCreateBy());
        serviceRelationship.setUpdateTime(new Date());
        serviceRelationship.setUpdateBy(checkIn.getUpdateBy());
        serviceRelationship.setIsDeleted(0);
        serviceRelationshipMapper.insert(serviceRelationship);

        //新增food_customer记录
        FoodCustomer foodCustomer=new FoodCustomer();
        foodCustomer.setCreate_by(checkIn.getCreateBy().toString());
        foodCustomer.setCreate_date(new Date());
        foodCustomer.setUpdate_by(checkIn.getUpdateBy().toString());
        foodCustomer.setUpdate_date(new Date());
        foodCustomer.setDel_flag(0);
        foodCustomer.setCustomer_id(checkIn.getId().toString());
        foodCustomerMapper.insert(foodCustomer);
    }

//    ID查询
    @Override
    public CheckIn selectById(Integer id) {
        return checkInMapper.selectByPrimaryKey(id);
    }

//    删除记录（已删除字段改为1）
    @Override
    public void delete(Integer id) {
        CheckIn checkIn=checkInMapper.selectByPrimaryKey(id);
        checkIn.setIsDeleted(1);
        checkInMapper.updateByPrimaryKey(checkIn);

        //床位表改空闲
        Bed bed = new Bed();
        bed.setRoomNumber(checkIn.getRoomNumber());
        bed.setName(checkIn.getBedId().toString());
        bed=bedMapper.selectByElement(bed).get(0);
        bed.setBedStatus("0");
        bedMapper.updateByPrimaryKey(bed);

        //删除服务关系记录
        ServiceRelationship serviceRelationship =  new ServiceRelationship();
        serviceRelationship.setCustomerId(checkIn.getId());
        serviceRelationship=serviceRelationshipMapper.selectByElement(serviceRelationship).get(0);
        serviceRelationship.setUpdateTime(new Date());
        serviceRelationship.setUpdateBy(checkIn.getUpdateBy());
        serviceRelationship.setIsDeleted(1);
        serviceRelationshipMapper.update(serviceRelationship);

        //删除food_customer记录
        FoodCustomer foodCustomer=new FoodCustomer();
        foodCustomer.setCustomer_id(checkIn.getId().toString());
        foodCustomerMapper.delFoodCustomer1(foodCustomer);
    }

//    更新记录-不完整
    @Override
    public void update(CheckIn checkIn) {
        checkIn.setUpdateTime(new Date());
        checkInMapper.updateByPrimaryKey(checkIn);
    }
}
