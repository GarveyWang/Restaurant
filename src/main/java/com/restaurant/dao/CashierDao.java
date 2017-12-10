package com.restaurant.dao;

import com.restaurant.entity.Cashier;

public interface CashierDao {
    int deleteByPrimaryKey(Integer cId);

    int insert(Cashier record);

    int insertSelective(Cashier record);

    Cashier selectById(Integer cId);

    Cashier selectByRId(Integer rId);

    int updateByPrimaryKeySelective(Cashier record);

    int updateByPrimaryKey(Cashier record);
}