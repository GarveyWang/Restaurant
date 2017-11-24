package com.restaurant.service.impl;

import com.restaurant.dao.IDishDao;
import com.restaurant.model.Dish;
import com.restaurant.service.IDishService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("dishService")
public class DishService implements IDishService {
    @Resource
    private IDishDao dishDao;

    @Override
    public int insertSelective(Dish record) {
        return dishDao.insertSelective(record);
    }
}
