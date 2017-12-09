package com.restaurant.service.impl;

import com.restaurant.dao.CashierDao;
import com.restaurant.entity.Cashier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("cashierService")
public class CashierServiceImpl implements com.restaurant.service.CashierService {

    @Resource
    private CashierDao cashierDao;

    @Override
    public int insertSelective(Cashier record) {
        return cashierDao.insertSelective(record);
    }

    @Override
    public Cashier selectByRId(int rId) {
        return cashierDao.selectByRId(rId);
    }
}
