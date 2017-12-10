package com.restaurant.dao;

import com.restaurant.entity.OrderForm;

import java.util.List;

public interface OrderFormDao {
    int deleteByPrimaryKey(Integer oId);

    int insert(OrderForm record);

    int insertSelective(OrderForm record);

    OrderForm selectById(Integer oId);

    List<OrderForm> selectByRId(Integer rId);

    OrderForm selectNotEndByTId(Integer tId);

    List<OrderForm> selectNotEndByRId(int rId);

    int updateByPrimaryKeySelective(OrderForm record);

    int updateByPrimaryKey(OrderForm record);
}