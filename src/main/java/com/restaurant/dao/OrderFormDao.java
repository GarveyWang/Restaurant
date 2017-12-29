package com.restaurant.dao;

import com.restaurant.entity.OrderForm;

import java.util.List;

public interface OrderFormDao {
    /**
     * 通过订单Id删除对应订单记录
     * @param oId 订单Id
     * @return 删除数目
     */
    int deleteByPrimaryKey(Integer oId);

    /**
     * 插入订单记录
     * @param record 订单记录
     * @return 插入数目
     */
    int insert(OrderForm record);

    /**
     * 选择性插入订单记录，允许部分字段为空
     * @param record 订单记录
     * @return 插入数目
     */
    int insertSelective(OrderForm record);

    /**
     * 通过订单Id查询指定订单记录
     * @param oId 订单Id
     * @return 指定Id的订单对象
     */
    OrderForm selectById(Integer oId);

    /**
     * 通过餐馆Id查询该餐馆下所有的订单记录
     * @param rId 餐馆Id
     * @return 该餐馆下所有的订单List
     */
    List<OrderForm> selectByRId(Integer rId);

    /**
     * 通过餐桌Id查询该餐桌当前正在进行的订单记录
     * @param tId 餐桌Id
     * @return 该餐桌下所有的订单List
     */
    OrderForm selectNotEndByTId(Integer tId);

    /**
     * 通过餐馆Id查询该餐馆下所有未完成的订单记录
     * @param rId 餐馆Id
     * @return 该餐馆下所有的订单List
     */
    List<OrderForm> selectNotEndByRId(int rId);

    /**
     * 通过主键选择性更新订单记录，仅更新非空属性对应的字段
     * @param record 订单记录
     * @return 更新数目
     */
    int updateByPrimaryKeySelective(OrderForm record);

    /**
     * 通过主键更新订单记录，更新所有字段
     * @param record 订单记录
     * @return 更新数目
     */
    int updateByPrimaryKey(OrderForm record);
}