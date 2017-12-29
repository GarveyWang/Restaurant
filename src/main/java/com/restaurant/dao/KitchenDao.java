package com.restaurant.dao;

import com.restaurant.entity.Kitchen;

import java.util.List;

public interface KitchenDao {
    /**
     * 通过厨房Id删除对应厨房记录
     * @param kId 厨房Id
     * @return 删除数目
     */
    int deleteById(Integer kId);

    /**
     * 插入厨房账号记录
     * @param record 厨房账号记录
     * @return 插入数目
     */
    int insert(Kitchen record);

    /**
     * 选择性插入厨房账号记录，允许部分字段为空
     * @param record 厨房账号记录
     * @return 插入数目
     */
    int insertSelective(Kitchen record);

    /**
     * 通过厨房Id查询指定厨房记录
     * @param kId 厨房Id
     * @return 指定Id的厨房对象
     */
    Kitchen selectById(Integer kId);

    /**
     * 通过餐馆Id查询该餐馆下所有的厨房账号记录
     * @param rId 餐馆Id
     * @return 该餐馆下所有的厨房账号List
     */
    List<Kitchen> selectByRId(Integer rId);

    /**
     * 通过主键选择性更新厨房账号记录，仅更新非空属性对应的字段
     * @param record 厨房记录
     * @return 更新数目
     */
    int updateByPrimaryKeySelective(Kitchen record);

    /**
     * 通过主键更新厨房账号记录，更新所有字段
     * @param record 厨房账号记录
     * @return 更新数目
     */
    int updateByPrimaryKey(Kitchen record);
}