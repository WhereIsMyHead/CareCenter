package com.czr.customer.controller;


import com.czr.customer.model.Bed;
import com.czr.customer.service.BedService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/bed")
public class BedController {

	@Resource
	private BedService bedService;

	@RequestMapping("/insert")
	public boolean insert(@RequestBody Bed bed){
		System.out.println("[insert]"+bed.toString());
		return bedService.insert(bed);
	}

	@RequestMapping("/delete")
	public boolean delete(@RequestBody Bed bed){
		System.out.println("[delete]" + bed.toString());
		return bedService.delete(bed);
	}

	@RequestMapping("/update")
	public boolean update(@RequestBody Bed bed){
		System.out.println("[update]" + bed.toString());
		return bedService.update(bed);
	}

	@RequestMapping("/search/{page}")
	public PageInfo<Bed> search(@PathVariable Integer page, @RequestBody Bed bed){
		System.out.println("[search]" + bed.toString());
		return bedService.search(page, bed);
	}
}
