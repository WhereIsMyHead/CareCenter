package com.czr.customer.controller;

import com.czr.customer.VO.OutgoingVO;
import com.czr.customer.model.Outgoing;
import com.czr.customer.service.OutgoingService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/outgoing")
public class OutgoingController {

    @Autowired
    OutgoingService outgoingService;

    @RequestMapping("list/{currPage}")
    public PageInfo<OutgoingVO> list(@PathVariable Integer currPage,@RequestBody Outgoing outgoing){
        return outgoingService.list(currPage,outgoing);
    }

//    @RequestMapping("get/{id}")
//    public OutgoingVO get(@PathVariable Integer id){
//        return outgoingService.getVO(id);
//    }

    @RequestMapping("add")
    public String add(@RequestBody Outgoing outgoing){
        outgoingService.add(outgoing);
        return "success";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        Outgoing outgoing = outgoingService.get(id);
        if (outgoing == null)
            return "not-exist";
        if (outgoing.getIsDeleted() == 1)
            return "not-exist";
        outgoingService.delete(id);
        return "success";
    }

    @RequestMapping("update")
    public String update(@RequestBody Outgoing outgoing) {
        Outgoing temp=outgoingService.get(outgoing.getId());
        if(temp==null)
            return "not-exist";
        if(temp.getIsDeleted()==1)
            return "not-exist";
        outgoingService.update(outgoing);
        return "success";
    }

}
