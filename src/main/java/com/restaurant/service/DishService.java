package com.restaurant.service;

import com.restaurant.entity.Dish;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;


public interface DishService {
    int insertSelective(Dish record);

    Dish selectById(Integer dId);

    RegisterStateEnum register(Dish dish);

    int getRIdByDId(int dId);

    DeleteStateEnum deleteById(int dId);

    UpdateStateEnum update(Dish dish);

}
