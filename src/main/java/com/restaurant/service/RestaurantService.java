package com.restaurant.service;

import com.restaurant.entity.Restaurant;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;

/**
 * 餐馆服务类
 */
public interface RestaurantService {

    /**
     * 通过Id选取对应的餐馆对象
     * @param id 餐馆Id
     * @return 对应的餐馆对象
     */
    public Restaurant selectById(int id);

    /**
     * 判断指定Id对应的餐馆是否存在
     * @param id 餐馆Id
     * @return 是否存在
     */
    public boolean isRestaurantExists(int id);

    /**
     * 新建餐馆记录
     * @param restaurant 餐馆对象
     * @return 新建数量
     */
    public int insert(Restaurant restaurant);

    /**
     * 验证餐馆登录账号密码是否正确
     * @param rest 待验证的餐馆对象
     * @return 登录状态
     */
    public LoginStateEnum validate(Restaurant rest);

    /**
     * 新建餐馆账号
     * @param rest 餐馆对象
     * @return 新建状态
     */
    public RegisterStateEnum register(Restaurant rest);

}