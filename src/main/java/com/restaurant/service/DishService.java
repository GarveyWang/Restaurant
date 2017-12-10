package com.restaurant.service;

import com.restaurant.entity.Dish;


public interface DishService {
    public int insertSelective(Dish record);

    public Dish selectById(Integer dId);
}
