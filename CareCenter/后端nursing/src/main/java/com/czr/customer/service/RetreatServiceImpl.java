package com.czr.customer.service;

import com.czr.customer.VO.RetreatVO;
import com.czr.customer.mapper.*;
import com.czr.customer.model.*;
import com.czr.customer.util.Define;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RetreatServiceImpl implements RetreatService{

    @Autowired
    RetreatMapper retreatMapper;

    @Autowired
    CheckInMapper checkInMapper;

    @Autowired
    BedMapper bedMapper;

    @Autowired
    ServiceRelationshipMapper serviceRelationshipMapper;

    @Autowired
    FoodCustomerMapper foodCustomerMapper;

    @Override
    public void setAgree(Retreat retreat) {
        retreatMapper.agree(retreat);
    }

    @Override
    public void add(Retreat retreat) {
        retreat.setIsDeleted(0);
        retreat.setCreateTime(new Date());
        retreat.setUpdateTime(new Date());
        retreatMapper.insert(retreat);

        CheckIn checkIn=new CheckIn();
        checkIn.setId(retreat.getCustomerId());
        System.out.println("================================"+checkIn.getId());
        checkIn=checkInMapper.selectByPrimaryKey(checkIn.getId());

        //床位表改退住
        Bed bed = new Bed();
        bed.setRoomNumber(checkIn.getRoomNumber());
        bed.setName(checkIn.getBedId().toString());
        bed=bedMapper.selectByElement(bed).get(0);
        bed.setBedStatus("3");
        bedMapper.updateByPrimaryKey(bed);

        //删除服务关系记录
        ServiceRelationship serviceRelationship =  new ServiceRelationship();
        serviceRelationship.setCustomerId(checkIn.getId());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(serviceRelationship.toString());
        serviceRelationship=serviceRelationshipMapper.selectByElement(serviceRelationship).get(0);
        serviceRelationship.setUpdateTime(new Date());
        serviceRelationship.setUpdateBy(checkIn.getUpdateBy());
        serviceRelationship.setIsDeleted(1);
        serviceRelationshipMapper.updateByPrimaryKey(serviceRelationship);

        //删除food_customer记录
        FoodCustomer foodCustomer=new FoodCustomer();
        foodCustomer.setCustomer_id(checkIn.getId().toString());
        foodCustomerMapper.delFoodCustomer1(foodCustomer);


//        //删除客户信息记录
//        checkIn.setIsDeleted(1);
//        checkInMapper.updateByPrimaryKey(checkIn);
    }

    @Override
    public void update(Retreat retreat) {
        retreat.setUpdateTime(new Date());
        retreatMapper.updateByPrimaryKey(retreat);
    }

    @Override
    public void delete(Integer id) {
        Retreat retreat=retreatMapper.selectByPrimaryKey(id);
        retreat.setIsDeleted(1);
        retreatMapper.updateByPrimaryKey(retreat);
    }

    @Override
    public Retreat get(Integer id) {
        return retreatMapper.selectByPrimaryKey(id);
    }

    private RetreatVO toVO(Retreat retreat){
        RetreatVO vo=new RetreatVO();
        vo.setAuditPerson(retreat.getAuditPerson());
        vo.setAuditStatus(retreat.getAuditStatus());
        vo.setAuditTine(retreat.getAuditTine());
        vo.setCreateBy(retreat.getCreateBy());
        vo.setCreateTime(retreat.getCreateTime());
        vo.setCustomerId(retreat.getCustomerId());
        vo.setId(retreat.getId());
        vo.setIsDeleted(retreat.getIsDeleted());
        vo.setRetreatReason(retreat.getRetreatReason());
        vo.setRetreatTime(retreat.getRetreatTime());
        vo.setRetreatType(retreat.getRetreatType());
        vo.setStatus(retreat.getStatus());
        vo.setUpdateBy(retreat.getUpdateBy());
        vo.setUpdateTime(retreat.getUpdateTime());

        CheckIn checkIn=new CheckIn();
        checkIn.setId(retreat.getCustomerId());
        checkIn=checkInMapper.selectByPrimaryKey(checkIn.getId());

        vo.setIdcard(checkIn.getIdcard());
        vo.setCustomerSex(checkIn.getCustomerSex());
        vo.setCustomerName(checkIn.getCustomerName());
        return vo;
    }

    @Override
    public PageInfo<RetreatVO> list(Integer currPage, Retreat retreat) {
        if(currPage == 0) currPage = 1;
        //设置从第几页查询N条
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        //分页查询

        List<Retreat> retreats=retreatMapper.selectByIsDelete(retreat);
        PageInfo pageInfo = new PageInfo<>(retreats);

//        转换成VO之后，分页total大小与实际不符的处理
        List<RetreatVO> retreatVOS=new ArrayList<>();
        for(int i=0;i<retreats.size();++i){
            retreatVOS.add(toVO(retreats.get(i)));
        }
        pageInfo.setList(retreatVOS);
        return pageInfo;
    }
}
