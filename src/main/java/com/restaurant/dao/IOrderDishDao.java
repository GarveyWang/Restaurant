package com.restaurant.dao;

import com.restaurant.model.OrderDish;
import com.restaurant.model.OrderDishKey;

public interface IOrderDishDao {
    int deleteByPrimaryKey(OrderDishKey key);

    int insert(OrderDish record);

    int insertSelective(OrderDish record);

    OrderDish selectByPrimaryKey(OrderDishKey key);

    int updateByPrimaryKeySelective(OrderDish record);

    int updateByPrimaryKey(OrderDish record);
}