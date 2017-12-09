package com.restaurant.service;

import com.restaurant.entity.Kitchen;

import java.util.List;

public interface KitchenService {
    public int insertSelective(Kitchen record);

    public List<Kitchen> selectByRId(int rId);
}
