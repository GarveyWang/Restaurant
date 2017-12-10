package com.restaurant.service.impl;

import com.restaurant.dao.OrderDishDao;
import com.restaurant.entity.OrderDish;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("orderDishService")
public class OrderDishServiceImpl implements com.restaurant.service.OrderDishService {
    @Resource
    private OrderDishDao orderDishDao;

    @Override
    public int insert(OrderDish record) {
        return orderDishDao.insert(record);
    }

    @Override
    public List<OrderDish> selectByOId(int oId) {
        return orderDishDao.selectByOId(oId);
    }

    @Override
    public List<OrderDish> selectNotEndByOId(int oId) {
        return orderDishDao.selectNotEndByOId(oId);
    }
}
