package com.restaurant.service.impl;

import com.restaurant.dao.DiningTableDao;
import com.restaurant.entity.DiningTable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("diningTableService")
public class DiningTableServiceImpl implements com.restaurant.service.DiningTableService {
    @Resource
    private DiningTableDao diningTableDao;

    @Override
    public int insertSelective(DiningTable record) {
        return diningTableDao.insertSelective(record);
    }
}
