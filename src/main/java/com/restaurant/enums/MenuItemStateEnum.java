package com.restaurant.enums;

/**
 * 菜单项状态枚举类
 */
public enum MenuItemStateEnum {
    NORMAL_SALE(0,"正常销售"),
    SOLD_OUT(1,"售罄");

    private int state;

    private String stateInfo;

    MenuItemStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static MenuItemStateEnum stateOf(int index){
        for(MenuItemStateEnum stateEnum:values()){
            if(stateEnum.getState()==index){
                return stateEnum;
            }
        }
        return null;
    }
}
