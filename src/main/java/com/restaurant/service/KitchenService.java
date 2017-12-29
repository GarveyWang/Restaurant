package com.restaurant.service;

import com.restaurant.dto.KitchenTaskItem;
import com.restaurant.entity.Kitchen;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;

public interface KitchenService {
    /**
     * 选择性插入厨房账号记录，允许部分属性为空
     * @param record 厨房账号记录
     * @return 插入数目
     */
    public int insertSelective(Kitchen record);

    /**
     * 通过餐馆Id查询该餐馆下的所有厨房账号
     * @param rId 餐馆Id
     * @return 厨房账号List
     */
    public List<Kitchen> selectByRId(int rId);

    /**
     * 通过厨房Id获取厨房账号对象
     * @param Id 厨房Id
     * @return 厨房账号对象
     */
    public Kitchen selectById(int Id);

    /**
     * 验证厨房账号密码是否正确
     * @param kitchen 待验证的厨房账号对象
     * @return 登录状态
     */
    public LoginStateEnum validate(Kitchen kitchen);

    /**
     * 通过餐馆Id获取后厨任务
     * @param rId 餐馆Id
     * @return 厨房任务List
     */
    public List<KitchenTaskItem> selectTaskByRId(int rId);

    /**
     * 新建厨房账号
     * @param kitchen 厨房记录
     * @return 注册状态
     */
    public RegisterStateEnum register(Kitchen kitchen);

    /**
     * 通过厨房Id获取餐馆Id
     * @param kId 厨房Id
     * @return 餐馆Id
     */
    public int getRIdByKId(int kId);

    /**
     * 通过厨房Id删除对应厨房记录
     * @param kId 厨房Id
     * @return 删除状态
     */
    public DeleteStateEnum deleteById(int kId);

    /**
     * 更新厨房记录
     * @param kitchen 厨房记录
     * @return 更新状态
     */
    public UpdateStateEnum update(Kitchen kitchen);
}
