package com.restaurant.dao;

import com.restaurant.model.Restaurant;

public interface IRestaurantDao {
    int deleteByPrimaryKey(Integer rId);

    int insert(Restaurant record);

    int insertSelective(Restaurant record);

    Restaurant selectRestaurantAndManager(Integer rId);

    int updateByPrimaryKeySelective(Restaurant record);

    int updateByPrimaryKey(Restaurant record);
}