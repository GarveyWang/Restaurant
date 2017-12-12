package com.restaurant.dao;


import com.restaurant.entity.OrderDish;
import com.restaurant.entity.OrderDishKey;

import java.util.List;

public interface OrderDishDao {
    int deleteByPrimaryKey(OrderDishKey key);

    int insert(OrderDish record);

    int insertSelective(OrderDish record);

    OrderDish selectByPrimaryKey(OrderDishKey key);

    int updateByPrimaryKeySelective(OrderDish record);

    int updateByPrimaryKey(OrderDish record);

    List<OrderDish> selectByOId(int oId);

    List<OrderDish> selectNotEndByOId(int oId);

    int addServeNumber(OrderDishKey key);
}