package com.restaurant.dao;

import com.restaurant.model.Cashier;

public interface ICashierDao {
    int deleteByPrimaryKey(Integer cId);

    int insert(Cashier record);

    int insertSelective(Cashier record);

    Cashier selectByPrimaryKey(Integer cId);

    Cashier selectByRId(Integer rId);

    int updateByPrimaryKeySelective(Cashier record);

    int updateByPrimaryKey(Cashier record);
}