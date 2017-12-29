package com.restaurant.service;

import com.restaurant.dto.SoldDishItem;
import com.restaurant.entity.Dish;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;


public interface DishService {
    int insertSelective(Dish record);

    Dish selectById(Integer dId);

    RegisterStateEnum register(Dish dish);

    int getRIdByDId(int dId);

    DeleteStateEnum deleteById(int dId);

    UpdateStateEnum update(Dish dish);

    List<SoldDishItem> getTop5SoldDishes(int rId);

}
