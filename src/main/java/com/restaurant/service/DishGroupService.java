package com.restaurant.service;


import com.restaurant.entity.DishGroup;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;

public interface DishGroupService {
    int insertSelective(DishGroup record);

    int insert(DishGroup record);

    List<DishGroup> selectByRId(int rId);

    DishGroup selectById(int dgId);

    int getDishCount(List<DishGroup> dishGroupList);

    int getRIdByDgId(int dgId);

    RegisterStateEnum register(DishGroup dishGroup);

    DeleteStateEnum deleteByDgId(int dgId);

    UpdateStateEnum update(DishGroup dishGroup);
}
