package com.restaurant.service;

import com.restaurant.entity.OrderDish;

import java.util.List;

public interface OrderDishService {
    public int insert(OrderDish record);

    public List<OrderDish> selectByOId(int oId);

    public List<OrderDish> selectNotEndByOId(int old);
}
