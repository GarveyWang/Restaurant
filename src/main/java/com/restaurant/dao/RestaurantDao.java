package com.restaurant.dao;

import com.restaurant.entity.Restaurant;

public interface RestaurantDao {

    Restaurant selectRestaurantById(Integer rId);

    Restaurant selectRestaurantByIdWithEmployee(Integer rId);

    Restaurant selectRestaurantAndKitchens(Integer rId);

    int deleteById(Integer rId);

    int insert(Restaurant record);

    int updateByIdSelective(Restaurant record);

    int updateById(Restaurant record);

    int getRestaurantCount(Integer rId);
}