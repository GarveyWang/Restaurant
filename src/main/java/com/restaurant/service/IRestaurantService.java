package com.restaurant.service;

import com.restaurant.model.Restaurant;

public interface IRestaurantService {
    public Restaurant selectRestaurant(int id);
    public int insertSelective(Restaurant record);
}
