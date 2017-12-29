package com.restaurant.service;

import com.restaurant.entity.DiningTable;
import com.restaurant.entity.TableGroup;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;

/**
 * 餐桌服务类
 */
public interface DiningTableService {
    /**
     * 选择性插入餐桌记录，允许部分属性为空
     * @param record 餐桌记录
     * @return 插入数目
     */
    public int insertSelective(DiningTable record);

    /**
     * 通过餐桌组Id获取其包含的所有餐桌对象
     * @param tgId 餐桌组Id
     * @return 该餐桌组包含的所有餐桌对象List
     */
    List<DiningTable> selectByTgId(int tgId);

    /**
     * 通过餐桌Id获取对应餐桌对象
     * @param tId 餐桌id
     * @return 餐桌对象
     */
    DiningTable selectById(int tId);

    /**
     * 验证该餐桌的服务码
     * @param table 待验证的餐桌对象
     * @return 登录状态
     */
    public LoginStateEnum validate(DiningTable table);

    /**
     * 新建餐桌记录
     * @param table 餐桌记录
     * @return 新建状态
     */
    public RegisterStateEnum register(DiningTable table);

    /**
     * 通过餐桌Id获取其所在的餐馆的Id
     * @param tId 餐桌Id
     * @return 餐馆Id
     */
    public int getRIdByTId(int tId);

    /**
     * 通过Id 删除对应的餐桌记录
     * @param tId 餐桌Id
     * @return 删除状态
     */
    public DeleteStateEnum deleteById(int tId);

    /**
     * 通过餐桌组Id删除该餐桌组包含的所有餐桌
     * @param tgId 餐桌组Id
     */
    public void deleteByTgId(int tgId);

    /**
     * 选择性更新餐桌信息，仅更新非空的属性对应的字段
     * @param table 餐桌记录
     * @return 更新状态
     */
    public UpdateStateEnum updateSelective(DiningTable table);

    /**
     * 更新餐桌的顾客信息
     * @param table 餐桌记录
     * @return 更新状态
     */
    public UpdateStateEnum updateGuestInfo(DiningTable table);

}
