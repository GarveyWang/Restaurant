package com.restaurant.service;

import com.restaurant.entity.OrderForm;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;

public interface OrderFormService {
    int insertSelective(OrderForm record);

    OrderForm selectNotEndByTId(int tId);

    List<OrderForm> selectNotEndByRId(int rId);

    RegisterStateEnum register(int rId, int tId);

    UpdateStateEnum end(OrderForm orderForm);
}
