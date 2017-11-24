package com.restaurant.service.impl;

import com.restaurant.dao.IDiningTableDao;
import com.restaurant.model.DiningTable;
import com.restaurant.service.IDiningTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("diningTableService")
public class DiningTableService implements IDiningTableService {
    @Resource
    private IDiningTableDao diningTableDao;

    @Override
    public int insertSelective(DiningTable record) {
        return diningTableDao.insertSelective(record);
    }
}
