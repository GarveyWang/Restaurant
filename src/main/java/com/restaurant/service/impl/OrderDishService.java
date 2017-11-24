package com.restaurant.service.impl;

import com.restaurant.dao.IOrderDishDao;
import com.restaurant.model.OrderDish;
import com.restaurant.service.IOrderDishService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("orderDishService")
public class OrderDishService implements IOrderDishService {
    @Resource
    private IOrderDishDao orderDishDao;

    @Override
    public int insert(OrderDish record) {
        return orderDishDao.insert(record);
    }
}
