package com.restaurant.dto;

import java.util.Date;

public class KitchenTaskItem {
    private int oId;
    private int dId;
    private String dishName;
    private int orderNumber;
    private int serveNumber;
    private String remark;
    private String tableGroupName;
    private String tableName;
    private Date orderTime;
    private String state;

    public KitchenTaskItem() {
    }

    public KitchenTaskItem(int oId, int dId, int orderNumber, int serveNumber, String remark, Date orderTime, String state) {
        this.oId = oId;
        this.dId = dId;
        this.orderNumber = orderNumber;
        this.serveNumber = serveNumber;
        this.remark = remark;
        this.orderTime = orderTime;
        this.state = state;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
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
