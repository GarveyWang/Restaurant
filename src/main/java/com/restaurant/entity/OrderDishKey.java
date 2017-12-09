package com.restaurant.entity;

import javax.annotation.Resource;

public class OrderDishKey {
    private Integer oId;

    private Integer dId;

    @Resource
    private OrderForm order;

    @Resource
    private Dish dish;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}