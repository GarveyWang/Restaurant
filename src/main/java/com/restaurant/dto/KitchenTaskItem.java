package com.restaurant.dto;

import java.util.Date;

public class KitchenTaskItem {
    private int dId;
    private String dishName;
    private int number;
    private String remark;
    private String tableGroupName;
    private String tableName;
    private Date orderTime;
    private String state;

    public KitchenTaskItem() {
    }

    public KitchenTaskItem(int dId, int number, String remark, Date orderTime, String state) {
        this.dId = dId;
        this.number = number;
        this.remark = remark;
        this.orderTime = orderTime;
        this.state = state;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTableGroupName() {
        return tableGroupName;
    }

    public void setTableGroupName(String tableGroupName) {
        this.tableGroupName = tableGroupName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
