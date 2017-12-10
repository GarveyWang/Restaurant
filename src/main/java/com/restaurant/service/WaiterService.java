package com.restaurant.service;

import com.restaurant.entity.Waiter;

import java.util.List;

public interface WaiterService {
    public int insertSelective(Waiter record);

    public Waiter selectById(int wId);

    public List<Waiter> selectByRId(int rId);

}
