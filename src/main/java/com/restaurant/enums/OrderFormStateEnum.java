package com.restaurant.enums;

public enum OrderFormStateEnum {
    NOT_END(0,"未结束"),
    END(1,"已结束");

    private int state;

    private String stateInfo;

    OrderFormStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static OrderFormStateEnum stateOf(int index){
        for(OrderFormStateEnum stateEnum:values()){
            if(stateEnum.getState()==index){
                return stateEnum;
            }
        }
        return null;
    }
}
