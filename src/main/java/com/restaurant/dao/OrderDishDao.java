package com.restaurant.dao;


import com.restaurant.entity.OrderDish;
import com.restaurant.entity.OrderDishKey;

import java.util.List;

/**
 * 点单相关Dao
 */
public interface OrderDishDao {
    /**
     * 通过主键删除对应点单记录
     * @param key 点单主键
     * @return 删除数目
     */
    int deleteByPrimaryKey(OrderDishKey key);

    /**
     * 插入点单记录
     * @param record 点单记录
     * @return 插入数目
     */
    int insert(OrderDish record);

    /**
     * 选择性插入点单记录，允许部分字段为空
     * @param record 点单记录
     * @return 插入数目
     */
    int insertSelective(OrderDish record);

    /**
     * 通过点单主键查询指定点单记录
     * @param key 点单主键
     * @return 指定主键的点单对象
     */
    OrderDish selectByPrimaryKey(OrderDishKey key);

    /**
     * 通过主键选择性更新点单记录，仅更新非空属性对应的字段
     * @param record 点单记录
     * @return 更新数目
     */
    int updateByPrimaryKeySelective(OrderDish record);

    /**
     * 通过主键更新点单记录，更新所有字段
     * @param record 点单记录
     * @return 更新数目
     */
    int updateByPrimaryKey(OrderDish record);

    /**
     * 通过订单Id选择对应点单记录
     * @param oId 订单Id
     * @return 该订单对应的所有点单记录List
     */
    List<OrderDish> selectByOId(int oId);

    /**
     * 通过订单Id选择对应还未上菜的点单记录
     * @param oId 订单Id
     * @return 该订单对应的还未上菜的点单记录List
     */
    List<OrderDish> selectNotEndByOId(int oId);

    /**
     * 将指定主键对应的记录中的serve_number加一
     * @param key 主键
     * @return 更新数目
     */
    int addServeNumber(OrderDishKey key);
}