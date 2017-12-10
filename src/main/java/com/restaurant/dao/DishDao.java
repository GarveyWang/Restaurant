package com.restaurant.dao;

import com.restaurant.entity.Dish;

import java.util.List;

public interface DishDao {
    int deleteByPrimaryKey(Integer dId);

    int insert(Dish record);

    int insertSelective(Dish record);

    Dish selectById(Integer dId);

    List<Dish> selectByDgId(Integer dgId);

    int updateByPrimaryKeySelective(Dish record);

    int updateByPrimaryKey(Dish record);
}