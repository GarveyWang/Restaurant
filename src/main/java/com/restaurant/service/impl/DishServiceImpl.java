package com.restaurant.service.impl;

import com.restaurant.dao.DishDao;
import com.restaurant.entity.Dish;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("dishService")
public class DishServiceImpl implements com.restaurant.service.DishService {
    @Resource
    private DishDao dishDao;

    @Override
    public int insertSelective(Dish record) {
        return dishDao.insertSelective(record);
    }
}
