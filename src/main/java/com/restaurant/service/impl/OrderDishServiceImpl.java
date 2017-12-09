package com.restaurant.service.impl;

import com.restaurant.dao.OrderDishDao;
import com.restaurant.entity.OrderDish;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("orderDishService")
public class OrderDishServiceImpl implements com.restaurant.service.OrderDishService {
    @Resource
    private OrderDishDao orderDishDao;

    @Override
    public int insert(OrderDish record) {
        return orderDishDao.insert(record);
    }
}
