package com.restaurant.service;

import com.restaurant.entity.Waiter;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 服务员服务类
 */
public interface WaiterService {
    /**
     * 选择性插入服务员账号记录，允许部分属性为空
     * @param record 服务员账号记录
     * @return 插入数目
     */
    public int insertSelective(Waiter record);

    /**
     * 通过服务员账号Id获取相应的服务员账号对象
     * @param wId 服务员Id
     * @return 服务员账号对象
     */
    public Waiter selectById(int wId);

    /**
     * 通过餐馆Id选择该餐馆下的服务员账号
     * @param rId 餐馆Id
     * @return 服务员账号List
     */
    public List<Waiter> selectByRId(int rId);

    /**
     * 验证服务员账号密码是否正确
     * @param waiter 待验证的服务员对象
     * @return 登录状态
     */
    public LoginStateEnum validate(Waiter waiter);

    /**
     * 新建服务员账号记录
     * @param waiter 服务员账号
     * @return 新建状态
     */
    public RegisterStateEnum register(Waiter waiter);

    /**
     * 通过服务员Id获取餐馆Id
     * @param wId 服务员Id
     * @return 餐馆Id
     */
    public int getRIdByWId(int wId);

    /**
     * 通过服务员Id删除对应服务员账号记录
     * @param wId 服务员账号Id
     * @return 删除状态
     */
    public DeleteStateEnum deleteById(int wId);

    /**
     * 更新服务员账号
     * @param waiter 服务员账号
     * @return 更新状态
     */
    public UpdateStateEnum update(Waiter waiter);
}
