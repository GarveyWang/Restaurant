package com.restaurant.dto;

import java.util.Date;

public class OrderFormItem {
    private int dId;
    private String name;
    private int price;
    private int number;
    private String remark;
    private String state;
    private Date orderTime;

    public OrderFormItem() {
    }

    public OrderFormItem(int dId, int number, String remark, String state, Date orderTime) {
        this.dId = dId;
        this.number = number;
        this.remark = remark;
        this.state = state;
        this.orderTime=orderTime;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
