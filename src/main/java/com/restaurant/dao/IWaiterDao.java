package com.restaurant.dao;

import com.restaurant.model.Waiter;

public interface IWaiterDao {
    int deleteByPrimaryKey(Integer wId);

    int insert(Waiter record);

    int insertSelective(Waiter record);

    Waiter selectByPrimaryKey(Integer wId);

    int updateByPrimaryKeySelective(Waiter record);

    int updateByPrimaryKey(Waiter record);
}