package com.restaurant.service;

import com.restaurant.entity.Restaurant;

public interface RestaurantService {

    public Restaurant selectRestaurantById(int id);

    public Restaurant selectRestaurantByIdWithEmployee(int id);

    public boolean isRestaurantExists(int id);

    public int insert(Restaurant restaurant);

}