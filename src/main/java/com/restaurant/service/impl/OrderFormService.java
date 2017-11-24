package com.restaurant.service.impl;

import com.restaurant.dao.IOrderFormDao;
import com.restaurant.model.OrderForm;
import com.restaurant.service.IOrderFormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("orderService")
public class OrderFormService implements IOrderFormService {
    @Resource
    private IOrderFormDao orderDao;

    @Override
    public int insertSelective(OrderForm record) {
        return orderDao.insertSelective(record);
    }
}
