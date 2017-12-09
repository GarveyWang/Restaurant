package com.restaurant.service.impl;

import com.restaurant.dao.OrderFormDao;
import com.restaurant.entity.OrderForm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("orderService")
public class OrderFormServiceImpl implements com.restaurant.service.OrderFormService {
    @Resource
    private OrderFormDao orderDao;

    @Override
    public int insertSelective(OrderForm record) {
        return orderDao.insertSelective(record);
    }
}
