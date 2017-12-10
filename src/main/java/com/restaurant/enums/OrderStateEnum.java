package com.restaurant.enums;

public enum OrderStateEnum {
    ORDERING(0,"正在点单"),
    SUBMITTED(1,"已提交"),
    END(2,"已结账");

    private int state;

    private String stateInfo;

    OrderStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static OrderStateEnum stateOf(int index){
        for(OrderStateEnum stateEnum:values()){
            if(stateEnum.getState()==index){
                return stateEnum;
            }
        }
        return null;
    }
}
