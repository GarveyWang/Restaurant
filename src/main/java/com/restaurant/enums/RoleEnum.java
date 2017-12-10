package com.restaurant.enums;

public enum RoleEnum {
    ADMIN(0,"admin"),
    WAITER(1,"waiter"),
    CASHIER(2,"cashier"),
    KITCHEN(3,"kitchen"),
    CUSTOMER(4,"customer");

    private int roleCode;

    private String role;

    RoleEnum(int roleCode, String role) {
        this.roleCode = roleCode;
        this.role = role;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public String getRole() {
        return role;
    }

    public static RoleEnum roleOf(int index){
        for(RoleEnum roleEnum:values()){
            if(roleEnum.getRoleCode()==index){
                return roleEnum;
            }
        }
        return null;
    }
}
