package com.restaurant.dao;

import com.restaurant.entity.OrderDish;
import com.restaurant.entity.OrderDishKey;

public interface OrderDishDao {
    int deleteByPrimaryKey(OrderDishKey key);

    int insert(OrderDish record);

    int insertSelective(OrderDish record);

    OrderDish selectByPrimaryKey(OrderDishKey key);

    int updateByPrimaryKeySelective(OrderDish record);

    int updateByPrimaryKey(OrderDish record);
}