package com.restaurant.service.impl;

import com.restaurant.dao.WaiterDao;
import com.restaurant.entity.Waiter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("waiterService")
public class WaiterServiceImpl implements com.restaurant.service.WaiterService {
    @Resource
    private WaiterDao waiterDao;

    @Override
    public int insertSelective(Waiter record){
        return waiterDao.insertSelective(record);
    }

    @Override
    public List<Waiter> selectByRId(int rId) {
        return waiterDao.selectByRId(rId);
    }

    @Override
    public Waiter selectById(int wId) {
        return waiterDao.selectById(wId);
    }
}
