package com.restaurant.service;

import com.restaurant.entity.DiningTable;
import com.restaurant.entity.DishGroup;

import java.util.List;

public interface DishGroupService {
    int insertSelective(DishGroup record);

    int insert(DishGroup record);

    List<DishGroup> selectByRId(int rId);
}
