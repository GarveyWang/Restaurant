package com.restaurant.service;

import com.restaurant.dto.KitchenTaskItem;
import com.restaurant.entity.Kitchen;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;

public interface KitchenService {
    public int insertSelective(Kitchen record);

    public List<Kitchen> selectByRId(int rId);

    public Kitchen selectById(int Id);

    public LoginStateEnum validate(Kitchen kitchen);

    public List<KitchenTaskItem> selectTaskByRId(int rId);

    public RegisterStateEnum register(Kitchen kitchen);

    public int getRIdByKId(int kId);

    public DeleteStateEnum deleteById(int kId);

    public UpdateStateEnum update(Kitchen kitchen);
}
