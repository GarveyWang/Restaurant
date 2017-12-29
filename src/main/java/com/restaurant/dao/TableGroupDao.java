package com.restaurant.dao;

import com.restaurant.entity.TableGroup;

import java.util.List;

public interface TableGroupDao {
    /**
     * 通过餐桌组Id删除对应餐桌组记录
     * @param tgId 餐桌组Id
     * @return 删除数目
     */
    int deleteByPrimaryKey(Integer tgId);

    /**
     * 插入餐桌组记录
     * @param record 餐桌组记录
     * @return 插入数目
     */
    int insert(TableGroup record);

    /**
     * 选择性插入餐桌组记录，允许部分字段为空
     * @param record 餐桌组记录
     * @return 插入数目
     */
    int insertSelective(TableGroup record);

    /**
     * 通过餐桌组Id查询指定餐桌组记录
     * @param tgId 餐桌组Id
     * @return 指定Id的餐桌组对象
     */
    TableGroup selectById(Integer tgId);

    /**
     * 通过餐馆Id查询该餐馆下所有的餐桌组记录
     * @param rId 餐馆Id
     * @return 该餐馆下所有的餐桌组List
     */
    List<TableGroup> selectByRId(Integer rId);

    /**
     * 通过主键选择性更新餐桌组记录，仅更新非空属性对应的字段
     * @param record 餐桌组记录
     * @return 更新数目
     */
    int updateByPrimaryKeySelective(TableGroup record);

    /**
     * 通过主键更新餐桌组记录，更新所有字段
     * @param record 餐桌组记录
     * @return 更新数目
     */
    int updateByPrimaryKey(TableGroup record);
}