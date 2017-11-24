package com.restaurant.dao;

import com.restaurant.model.Dish;

public interface IDishDao {
    int deleteByPrimaryKey(Integer dId);

    int insert(Dish record);

    int insertSelective(Dish record);

    Dish selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(Dish record);

    int updateByPrimaryKey(Dish record);
}