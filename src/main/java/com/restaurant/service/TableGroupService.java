package com.restaurant.service;

import com.restaurant.entity.TableGroup;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;

/**
 * 餐桌组服务
 */
public interface TableGroupService {
    /**
     * 选择性插入餐桌组记录，允许部分属性为空
     * @param record 餐桌组记录
     * @return 插入数目
     */
    int insertSelective(TableGroup record);

    /**
     * 插入餐桌组记录
     * @param record 餐桌组记录
     * @return 插入数目
     */
    int insert(TableGroup record);

    /**
     * 通过餐桌组Id获取对应的餐桌组对象
     * @param tgId 餐桌组Id
     * @return 餐桌组List
     */
    TableGroup selectById(int tgId);

    /**
     * 通过餐馆Id查询该餐馆的餐桌组
     * @param rId 餐馆Id
     * @return 餐桌组List
     */
    List<TableGroup> selectByRId(int rId);

    /**
     * 新建餐桌组记录
     * @param tableGroup 餐桌组对象
     * @return 新建状态
     */
    RegisterStateEnum register(TableGroup tableGroup);

    /**
     * 获取一个餐桌组List包含的所有餐桌数量
     * @param tableGroupList 餐桌组List
     * @return 餐桌总数
     */
    int getTableCount(List<TableGroup> tableGroupList);

    /**
     * 通过餐桌组Id获取对应餐馆Id
     * @param tgId 餐桌组Id
     * @return 餐馆id
     */
    int getRIdByTgId(int tgId);

    /**
     * 通过餐桌组Id删除对应的餐桌组记录
     * @param tgId 餐桌组Id
     * @return 删除状态
     */
    DeleteStateEnum deleteByTgId(int tgId);

    /**
     * 更新餐桌组
     * @param tableGroup 餐桌组
     * @return 更新状态
     */
    UpdateStateEnum update(TableGroup tableGroup);
}
