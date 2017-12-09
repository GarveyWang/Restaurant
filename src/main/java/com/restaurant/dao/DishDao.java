package com.restaurant.dao;

import com.restaurant.entity.Dish;

public interface DishDao {
    int deleteByPrimaryKey(Integer dId);

    int insert(Dish record);

    int insertSelective(Dish record);

    Dish selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(Dish record);

    int updateByPrimaryKey(Dish record);
}