package com.restaurant.service;


import com.restaurant.entity.DishGroup;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;

/**
 * 餐桌组服务类
 */
public interface DishGroupService {
    /**
     * 选择性插入菜品组记录，允许部分属性为空
     * @param record 菜品组记录
     * @return 插入数目
     */
    int insertSelective(DishGroup record);

    /**
     * 插入菜品组记录
     * @param record 菜品组记录
     * @return 插入数目
     */
    int insert(DishGroup record);

    /**
     * 通过餐馆Id获取该餐馆下的菜品组List
     * @param rId 餐馆Id
     * @return 菜品组List
     */
    List<DishGroup> selectByRId(int rId);

    /**
     * 通过菜品组Id获取对应菜品组对象
     * @param dgId 菜品组id
     * @return 菜品组对象
     */
    DishGroup selectById(int dgId);

    /**
     * 获取一个菜品组List包含的所有菜品数量
     * @param dishGroupList 菜品组List
     * @return 菜品总数
     */
    int getDishCount(List<DishGroup> dishGroupList);

    /**
     * 通过菜品组Id获取餐馆Id
     * @param dgId 菜品组Id
     * @return 餐馆Id
     */
    int getRIdByDgId(int dgId);

    /**
     * 新建菜品组记录
     * @param dishGroup 菜品组对象
     * @return 新建状态
     */
    RegisterStateEnum register(DishGroup dishGroup);

    /**
     * 通过菜品组Id删除对应菜品组
     * @param dgId 菜品组Id
     * @return 删除状态
     */
    DeleteStateEnum deleteByDgId(int dgId);

    /**
     * 更新菜品组
     * @param dishGroup 菜品组对象
     * @return 更新状态
     */
    UpdateStateEnum update(DishGroup dishGroup);
}
