package com.czr.customer.service;

import com.czr.customer.VO.OutgoingVO;
import com.czr.customer.mapper.BedMapper;
import com.czr.customer.mapper.CheckInMapper;
import com.czr.customer.mapper.OutgoingMapper;
import com.czr.customer.model.Bed;
import com.czr.customer.model.CheckIn;
import com.czr.customer.model.Outgoing;
import com.czr.customer.util.Define;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OutgoingServiceImpl implements OutgoingService{

    @Autowired
    OutgoingMapper outgoingMapper;

    @Autowired
    CheckInMapper checkInMapper;

    @Autowired
    BedMapper bedMapper;

    @Override
    public void add(Outgoing outgoing) {

        outgoing.setIsDeleted(0);
        outgoing.setCreateTime(new Date());
        outgoing.setUpdateTime(new Date());
        outgoingMapper.insert(outgoing);
        System.out.println(outgoing.toString()+"====================================");

        CheckIn checkIn=new CheckIn();
        checkIn.setId(outgoing.getCustomerId());
        checkIn=checkInMapper.selectByPrimaryKey(checkIn.getId());


        //床位表改外出
        Bed bed = new Bed();
        bed.setRoomNumber(checkIn.getRoomNumber());
        bed.setName(checkIn.getBedId().toString());
        bed=bedMapper.selectByElement(bed).get(0);
        bed.setBedStatus("2");
        bedMapper.updateByPrimaryKey(bed);
    }

    @Override
    public void update(Outgoing outgoing) {
        outgoing.setUpdateTime(new Date());
        outgoingMapper.updateByPrimaryKey(outgoing);
    }

    @Override
    public void delete(Integer id) {
        Outgoing outgoing=outgoingMapper.selectByPrimaryKey(id);
        outgoing.setIsDeleted(1);
        outgoingMapper.updateByPrimaryKey(outgoing);
    }

//    @Override
//
//    //通过老人id查询
//    public OutgoingVO getVO(Integer id) {
//        Outgoing outgoing=outgoingMapper.selectByPrimaryKey(id);
//        OutgoingVO vo=toVO(outgoing);
//        return vo;
//    }

    @Override
    public Outgoing get(Integer id) {
        return outgoingMapper.selectByPrimaryKey(id);
    }

    private OutgoingVO toVO(Outgoing outgoing){
        OutgoingVO vo=new OutgoingVO();
        vo.setActualReturnTime(outgoing.getActualReturnTime());
        vo.setAuditPerson(outgoing.getAuditPerson());
        vo.setAuditStatus(outgoing.getAuditStatus());
        vo.setAuditTine(outgoing.getAuditTine());
        vo.setCreateBy(outgoing.getCreateBy());
        vo.setUpdateBy(outgoing.getUpdateBy());
        vo.setCreateTime(outgoing.getCreateTime());
        vo.setEscorted(outgoing.getEscorted());
        vo.setEscortedTel(outgoing.getEscortedTel());
        vo.setExpectedReturnTime(outgoing.getExpectedReturnTime());
        vo.setId(outgoing.getId());
        vo.setOutgoingReason(outgoing.getOutgoingReason());
        vo.setOutgoingTime(outgoing.getOutgoingTime());
        vo.setRelation(outgoing.getRelation());
        vo.setUpdateTime(outgoing.getUpdateTime());

        CheckIn checkIn=new CheckIn();
        checkIn.setId(outgoing.getCustomerId());
        checkIn=checkInMapper.selectByPrimaryKey(checkIn.getId());
        vo.setCustomerId(checkIn.getId());
        vo.setRoomNumber(checkIn.getRoomNumber());
        vo.setIdcard(checkIn.getIdcard());
        vo.setCustomerSex(checkIn.getCustomerSex());
        vo.setCustomerName(checkIn.getCustomerName());
        vo.setCustomerAge(checkIn.getCustomerAge());
        vo.setContactTel(checkIn.getContactTel());
        vo.setBuildingId(checkIn.getBuildingId());
        vo.setBedId(checkIn.getBedId());
        return vo;
    }

    @Override
    public PageInfo<OutgoingVO> list(Integer currPage,Outgoing outgoing) {
//        CheckIn checkIn=new CheckIn();
//        checkIn.setCustomerName(outgoingVO.getCustomerName());
//        List<CheckIn> checkInList=checkInMapper.selectByIsDelete(checkIn);
//        for(int i=0;i<checkInList.size();i++){
//            checkInList.get(i).getId();
//        }
        if(currPage == 0) currPage = 1;
        //设置从第几页查询N条
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        //分页查询
        List<Outgoing> outgoings=outgoingMapper.selectByIsDelete(outgoing);
        PageInfo pageInfo = new PageInfo<>(outgoings);

//        转换成VO之后，分页total大小与实际不符的处理
        List<OutgoingVO> outgoingVOS=new ArrayList<>();
        for(int i=0;i<outgoings.size();++i){
            outgoingVOS.add(toVO(outgoings.get(i)));
        }
        pageInfo.setList(outgoingVOS);
        return pageInfo;
    }
}
