package com.czr.customer.service;

import com.czr.customer.mapper.CheckInMapper;
import com.czr.customer.model.CheckIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private CheckInMapper checkInMapper;

    @Override
    public List<CheckIn> selectAll() {
        return checkInMapper.selectAll();
    }
}
