package com.restaurant.service;

import com.restaurant.entity.Cashier;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.UpdateStateEnum;

public interface CashierService {
    /**
     * 选择性插入收银台记录
     * @param record 收银台记录
     * @return 插入数目
     */
    public int insertSelective(Cashier record);

    /**
     * 通过餐馆Id获取该餐馆的收银台对象
     * @param rId 餐馆Id
     * @return 对应的首台对象
     */
    public Cashier selectByRId(int rId);

    /**
     * 通过收银台Id获取对应的收银台对象
     * @param cId 收银台Id
     * @return 收银台对象
     */
    public Cashier selectById(int cId);

    /**
     * 验证收银台账号密码
     * @param cashier 待验证的收银台对象
     * @return 登录状态
     */
    public LoginStateEnum validate(Cashier cashier);

    /**
     * 通过餐馆Id注册对应的收银台账号
     * @param rId 餐馆Id
     */
    public void registerByRId(int rId);

    /**
     * 更新收银台记录
     * @param cashier 收银台记录
     * @return 更新状态
     */
    public UpdateStateEnum update(Cashier cashier);
}
