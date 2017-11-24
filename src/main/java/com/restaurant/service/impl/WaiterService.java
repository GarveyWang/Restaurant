package com.restaurant.service.impl;

import com.restaurant.dao.IWaiterDao;
import com.restaurant.model.Waiter;
import com.restaurant.service.IWaiterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("waiterService")
public class WaiterService implements IWaiterService {
    @Resource
    private IWaiterDao waiterDao;

    @Override
    public int insertSelective(Waiter record){
        return waiterDao.insertSelective(record);
    }
}
