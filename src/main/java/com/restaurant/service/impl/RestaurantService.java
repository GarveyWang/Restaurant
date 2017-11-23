package com.restaurant.service.impl;

import com.restaurant.dao.IRestaurantDao;
import com.restaurant.model.Restaurant;
import com.restaurant.service.IRestaurantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("restaurantService")
public class RestaurantService implements IRestaurantService {
    @Resource
    private IRestaurantDao restaurantDao;

    public Restaurant selectRestaurant(int id){
        return restaurantDao.selectRestaurantAndManager(id);
    }

}
