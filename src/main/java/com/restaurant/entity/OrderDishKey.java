package com.restaurant.entity;

import javax.annotation.Resource;

/**
 * 点单主键
 */
public class OrderDishKey {
    private Integer oId;

    private Integer dId;

    public OrderDishKey() {
    }

    public OrderDishKey(Integer oId, Integer dId) {
        this.oId = oId;
        this.dId = dId;
    }

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