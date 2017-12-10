package com.restaurant.entity;

import javax.annotation.Resource;
import java.util.List;

public class Restaurant {
    private Integer rId;

    private String password;

    private String name;

    @Resource
    private Cashier cashier;

    @Resource
    private List<Waiter> waiters;

    @Resource
    private List<Kitchen> kitchens;

    @Resource
    private List<TableGroup> tableGroups;

    @Resource
    private List<DishGroup> dishGroups;

    @Resource
    private List<OrderForm> orderForms;

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public List<Waiter> getWaiters() {
        return waiters;
    }

    public void setWaiters(List<Waiter> waiters) {
        this.waiters = waiters;
    }

    public List<Kitchen> getKitchens() {
        return kitchens;
    }

    public void setKitchens(List<Kitchen> kitchens) {
        this.kitchens = kitchens;
    }

    public List<TableGroup> getTableGroups() {
        return tableGroups;
    }

    public void setTableGroups(List<TableGroup> tableGroups) {
        this.tableGroups = tableGroups;
    }

    public List<DishGroup> getDishGroups() {
        return dishGroups;
    }

    public void setDishGroups(List<DishGroup> dishGroups) {
        this.dishGroups = dishGroups;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<OrderForm> getOrderForms() {
        return orderForms;
    }

    public void setOrderForms(List<OrderForm> orderForms) {
        this.orderForms = orderForms;
    }
}