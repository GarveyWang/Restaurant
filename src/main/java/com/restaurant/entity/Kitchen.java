package com.restaurant.entity;


public class Kitchen {

    private Integer kId;

    private String password;

    private String name;

    private Byte active;

    private Integer rId;

    public Integer getkId() {
        return kId;
    }

    public void setkId(Integer kId) {
        this.kId = kId;
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

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }
}