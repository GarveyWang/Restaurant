package com.restaurant.dao;

import com.restaurant.entity.DishGroup;

import java.util.List;

/**
 * 菜品组相关Dao
 */
public interface DishGroupDao {
    /**
     * 通过菜品组Id删除对应菜品组记录
     * @param dgId 菜品组Id
     * @return 删除数目
     */
    int deleteByPrimaryKey(Integer dgId);

    /**
     * 插入菜品组记录
     * @param record 菜品组记录
     * @return 插入数目
     */
    int insert(DishGroup record);

    /**
     * 选择性插入菜品组记录，允许部分字段为空
     * @param record 菜品组记录
     * @return 插入数目
     */
    int insertSelective(DishGroup record);

    /**
     * 通过菜品组Id查询指定菜品组记录
     * @param dgId 菜品组Id
     * @return 指定Id的菜品组对象
     */
    DishGroup selectByPrimaryKey(Integer dgId);

    /**
     * 通过餐馆Id查询该餐馆包含的菜品组
     * @param rId 餐馆Id
     * @return 该餐馆的菜品组List
     */
    List<DishGroup> selectByRId(Integer rId);

    /**
     * 通过主键选择性更新菜品组记录，仅更新非空属性对应的字段
     * @param record 菜品组记录
     * @return 更新数目
     */
    int updateByPrimaryKeySelective(DishGroup record);

    /**
     * 通过主键更新菜品组记录，更新所有字段
     * @param record 菜品组记录
     * @return 更新数目
     */
    int updateByPrimaryKey(DishGroup record);
}