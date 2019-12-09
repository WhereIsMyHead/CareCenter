package com.czr.customer.controller;

import com.czr.customer.VO.RetreatVO;
import com.czr.customer.model.Retreat;
import com.czr.customer.service.RetreatService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/retreat")
public class RetreatController {

    @Autowired
    RetreatService retreatService;

    @RequestMapping("list/{currPage}")
    public PageInfo<RetreatVO> list(@PathVariable Integer currPage, @RequestBody Retreat retreat){
        return retreatService.list(currPage,retreat);
    }

    @RequestMapping("get/{id}")
    public Retreat get(@PathVariable Integer id){
        return retreatService.get(id);
    }

    @RequestMapping("add")
    public String add(@RequestBody Retreat retreat){
        retreatService.add(retreat);
        return "success";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        Retreat retreat = retreatService.get(id);
        if (retreat == null)
            return "not-exist";
        if (retreat.getIsDeleted() == 1)
            return "not-exist";
        retreatService.delete(id);
        return "success";
    }

    @RequestMapping("update")
    public String update(@RequestBody Retreat retreat) {
        Retreat temp=retreatService.get(retreat.getId());
        if(temp==null)
            return "not-exist";
        if(temp.getIsDeleted()==1)
            return "not-exist";
        retreatService.update(retreat);
        return "success";
    }

    @RequestMapping("agree")
    public String agree(@RequestBody Retreat retreat) {
        Retreat temp=retreatService.get(retreat.getId());
        if(temp==null)
            return "not-exist";
        if(temp.getIsDeleted()==1)
            return "not-exist";
        retreatService.setAgree(retreat);
        return "success";
    }



}
