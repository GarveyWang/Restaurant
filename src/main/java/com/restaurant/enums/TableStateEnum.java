package com.restaurant.enums;

public enum TableStateEnum {
    FREE(0,"空闲"),
    BUSY(1,"有客");

    private int state;

    private String stateInfo;

    TableStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static TableStateEnum stateOf(int index){
        for(TableStateEnum stateEnum:values()){
            if(stateEnum.getState()==index){
                return stateEnum;
            }
        }
        return null;
    }
}
