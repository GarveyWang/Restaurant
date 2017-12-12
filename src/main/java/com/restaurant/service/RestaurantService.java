package com.restaurant.service;

import com.restaurant.entity.Restaurant;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;

public interface RestaurantService {

    public Restaurant selectById(int id);

    public boolean isRestaurantExists(int id);

    public int insert(Restaurant restaurant);

    public LoginStateEnum validate(Restaurant rest);

    public RegisterStateEnum register(Restaurant rest);

}