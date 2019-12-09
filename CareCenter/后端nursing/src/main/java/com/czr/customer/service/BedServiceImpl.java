package com.czr.customer.service;

import com.czr.customer.mapper.BedMapper;
import com.czr.customer.model.Bed;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BedServiceImpl implements BedService {

	@Autowired
	private BedMapper bedMapper;

	@Override
	public boolean insert(Bed bed) {
		bed.setCreateTime(new Date());
		bed.setUpdateTime(new Date());
		bedMapper.insert(bed);
		return true;
	}

	@Override
	public boolean delete(Bed bed) {
		Bed bed1 = new Bed(bed);
		List<Bed> beds = bedMapper.selectByElement(bed1);
		if (beds.size() <= 0)return false;
		for(Bed b:beds) {
			b.setIsDeleted(1);
			bedMapper.updateByPrimaryKey(b);
		}
		return true;
	}

	@Override
	public boolean update(Bed bed) {
		bed.setUpdateTime(new Date());
		bedMapper.updateByPrimaryKey(bed);
		return true;
	}

	@Override
	public PageInfo<Bed> search(Integer page, Bed bed) {
		Bed bed1 = new Bed(bed);
		if(page == null) page = 1;
		//设置从第几页查询N条
		PageHelper.startPage(page, 10);
		//分页查询
		PageInfo<Bed> pageInfo = new PageInfo<>(bedMapper.selectByElement(bed1));
		return pageInfo;
	}
}
