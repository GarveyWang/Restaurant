package com.restaurant.service;

import com.restaurant.entity.OrderForm;

import java.util.List;

public interface OrderFormService {
    public int insertSelective(OrderForm record);

    public OrderForm selectNotEndByTId(int tId);

    public List<OrderForm> selectNotEndByRId(int rId);
}
