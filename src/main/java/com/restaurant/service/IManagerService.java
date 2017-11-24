package com.restaurant.service;

import com.restaurant.model.Manager;

public interface IManagerService {
    public int insertSelective(Manager record);
    public Manager selectManager(int id);
}
