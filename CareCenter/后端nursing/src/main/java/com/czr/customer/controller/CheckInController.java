package com.czr.customer.controller;

import com.czr.customer.model.Bed;
import com.czr.customer.model.CheckIn;
import com.czr.customer.model.ServiceRelationship;
import com.czr.customer.service.BedService;
import com.czr.customer.service.CheckInService;
import com.czr.customer.service.RelationshipService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("check-in")
public class CheckInController {

    @Autowired
    CheckInService checkInService;

    @Autowired
    BedService bedService;

    @Autowired
    RelationshipService relationshipService;

    @RequestMapping("list/{currPage}")
    public PageInfo<CheckIn> list(@PathVariable Integer currPage,@RequestBody CheckIn checkIn){
        return checkInService.list(currPage,checkIn);
    }

    @RequestMapping("get/{id}")
    public CheckIn get(@PathVariable Integer id){
        return checkInService.selectById(id);
    }

    @RequestMapping("add")
    public String add(@RequestBody CheckIn checkIn){
//        if(checkInService.selectByIdcard(checkIn.getIdcard())!=null)
//            return "exist";
        checkInService.add(checkIn);
        return "success";
    }

//    @RequestMapping("select-all")
//    public List<CheckIn> all() {
//        return checkInService.selectAll();
//    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        CheckIn checkIn=checkInService.selectById(id);
        if(checkIn==null)
            return "not-exist";
        if(checkIn.getIsDeleted()==1)
            return "not-exist";
        checkInService.delete(id);
        return "success";
    }



    @RequestMapping("update")
    public String update(@RequestBody CheckIn checkIn) {
        CheckIn temp=checkInService.selectById(checkIn.getId());
        if(temp==null)
            return "not-exist";
        if(temp.getIsDeleted()==1)
            return "not-exist";
        checkInService.update(checkIn);
        return "success";
    }
}
