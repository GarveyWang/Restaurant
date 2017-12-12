package com.restaurant.dto;

import java.util.Date;

public class OrderFormItem {
    private int dId;
    private String name;
    private int price;
    private int orderNumber;
    private int serveNumber;
    private String remark;
    private String state;
    private Date orderTime;

    public OrderFormItem() {
    }

    public OrderFormItem(int dId, int orderNumber, int serveNumber, String remark, String state, Date orderTime) {
        this.dId = dId;
        this.orderNumber = orderNumber;
        this.serveNumber = serveNumber;
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

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getServeNumber() {
        return serveNumber;
    }

    public void setServeNumber(int serveNumber) {
        this.serveNumber = serveNumber;
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
