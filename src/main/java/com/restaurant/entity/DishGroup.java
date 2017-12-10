package com.restaurant.entity;

import javax.annotation.Resource;
import java.util.List;

public class DishGroup {
    private Integer dgId;

    private String name;

    private Integer rId;

    @Resource
    private List<Dish> dishes;

    public Integer getDgId() {
        return dgId;
    }

    public void setDgId(Integer dgId) {
        this.dgId = dgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}