package com.restaurant.service.impl;

import com.restaurant.dao.ICashierDao;
import com.restaurant.model.Cashier;
import com.restaurant.service.ICashierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("cashierService")
public class CashierService implements ICashierService {

    @Resource
    private ICashierDao cashierDao;

    @Override
    public int insertSelective(Cashier record) {
        return cashierDao.insertSelective(record);
    }
}
