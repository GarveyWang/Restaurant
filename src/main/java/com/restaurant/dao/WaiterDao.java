package com.restaurant.dao;

import com.restaurant.entity.Waiter;

import java.util.List;

public interface WaiterDao {

    int deleteByPrimaryKey(Integer wId);

    int insert(Waiter record);

    int insertSelective(Waiter record);

    Waiter selectById(Integer wId);

    List<Waiter> selectByRId(Integer rId);

    int updateByPrimaryKeySelective(Waiter record);

    int updateByPrimaryKey(Waiter record);
}