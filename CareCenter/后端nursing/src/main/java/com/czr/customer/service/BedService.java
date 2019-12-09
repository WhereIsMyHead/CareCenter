package com.czr.customer.service;


import com.czr.customer.model.Bed;
import com.github.pagehelper.PageInfo;

public interface BedService {

	boolean insert(Bed bed);

	boolean delete(Bed bed);

	boolean update(Bed bed);

	PageInfo<Bed> search(Integer page, Bed bed);

}
