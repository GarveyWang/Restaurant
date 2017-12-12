package com.restaurant.service;

import com.restaurant.entity.Cashier;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.UpdateStateEnum;

public interface CashierService {
    public int insertSelective(Cashier record);

    public Cashier selectByRId(int rId);

    public Cashier selectById(int cId);

    public LoginStateEnum validate(Cashier cashier);

    public void registerByRId(int rId);

    public UpdateStateEnum update(Cashier cashier);
}
