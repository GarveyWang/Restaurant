package com.restaurant.service.impl;

import com.restaurant.dao.RestaurantDao;
import com.restaurant.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("restaurantService")
public class RestaurantServiceImpl implements com.restaurant.service.RestaurantService {
    @Autowired
    private RestaurantDao restaurantDao;

    @Override
    public Restaurant selectRestaurantById(int id) {
        return restaurantDao.selectById(id);
    }

    @Override
    public boolean isRestaurantExists(int id) {
        int count=restaurantDao.getRestaurantCount(id);
        if(count == 0)
            return false;
        return true;
    }

    @Override
    public int insert(Restaurant restaurant) {
        return restaurantDao.insert(restaurant);
    }
}
