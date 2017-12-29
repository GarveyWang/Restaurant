package com.restaurant.dao;

import com.restaurant.entity.Restaurant;

/**
 * 餐馆相关Dao
 */
public interface RestaurantDao {

    /**
     * 通过餐馆Id查询指定餐馆记录
     * @param rId 餐馆Id
     * @return 指定Id的餐馆对象
     */
    Restaurant selectById(Integer rId);

    /**
     * 通过餐馆Id删除对应餐馆记录
     * @param rId 餐馆Id
     * @return 删除数目
     */
    int deleteById(Integer rId);

    /**
     * 插入餐馆记录
     * @param record 餐馆记录
     * @return 插入数目
     */
    int insert(Restaurant record);

    /**
     * 通过主键选择性更新餐馆记录，仅更新非空属性对应的字段
     * @param record 餐馆记录
     * @return 更新数目
     */
    int updateByIdSelective(Restaurant record);

    /**
     * 通过主键更新餐馆记录，更新所有字段
     * @param record 餐馆记录
     * @return 更新数目
     */
    int updateById(Restaurant record);

    /**
     * 通过餐馆Id查询该餐馆是否存在
     * @param rId 餐馆io
     * @return 餐馆数量为1则存在，0则不存在
     */
    int getRestaurantCount(Integer rId);
}