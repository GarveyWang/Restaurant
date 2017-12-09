package com.restaurant.service;

import com.restaurant.entity.Cashier;

public interface CashierService {
    public int insertSelective(Cashier record);

    public Cashier selectByRId(int rId);
}
