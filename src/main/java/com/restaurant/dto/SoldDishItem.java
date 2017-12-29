package com.restaurant.dto;

/**
 * 菜品售卖情况Dto
 */
public class SoldDishItem {
    private int dId;
    private int soldNumber;
    private String dishName;

    public SoldDishItem() {
    }

    public SoldDishItem(int dId, int soldNumber) {
        this.dId = dId;
        this.soldNumber = soldNumber;
    }


    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public int getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(int soldNumber) {
        this.soldNumber = soldNumber;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
}
