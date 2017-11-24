package com.restaurant.dao;

import com.restaurant.model.OrderForm;

public interface IOrderFormDao {
    int deleteByPrimaryKey(Integer oId);

    int insert(OrderForm record);

    int insertSelective(OrderForm record);

    OrderForm selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(OrderForm record);

    int updateByPrimaryKey(OrderForm record);
}