package com.restaurant.dao;

import com.restaurant.entity.DishGroup;

import java.util.List;

public interface DishGroupDao {
    int deleteByPrimaryKey(Integer dgId);

    int insert(DishGroup record);

    int insertSelective(DishGroup record);

    DishGroup selectByPrimaryKey(Integer dgId);

    List<DishGroup> selectByRId(Integer rId);

    int updateByPrimaryKeySelective(DishGroup record);

    int updateByPrimaryKey(DishGroup record);
}