package com.restaurant.enums;

public enum OrderDishStateEnum {
    WAITING(0,"排队中"),
    COOKING(1,"正在烹饪"),
    END(2,"已上菜");

    private int state;

    private String stateInfo;

    OrderDishStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static OrderDishStateEnum stateOf(int index){
        for(OrderDishStateEnum stateEnum:values()){
            if(stateEnum.getState()==index){
                return stateEnum;
            }
        }
        return null;
    }
}
