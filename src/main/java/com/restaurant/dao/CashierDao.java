package com.restaurant.dao;

import com.restaurant.entity.Cashier;

/**
 * 收银台相关Dao
 */
public interface CashierDao {
    /**
     * 通过主键删除指定收银台记录
     * @param cId 收银台Id
     * @return 删除数目
     */
    int deleteByPrimaryKey(Integer cId);

    /**
     * 插入收银台记录
     * @param record 收银台对象
     * @return 插入数目
     */
    int insert(Cashier record);

    /**
     * 插入收银台记录，部分字段可为空
     * @param record 收银台对象
     * @return 插入数目
     */
    int insertSelective(Cashier record);

    /**
     * 查询指定Id的收银台记录
     * @param cId 收银台Id
     * @return 指定收银台对象
     */
    Cashier selectById(Integer cId);

    /**
     * 通过餐馆Id查询该餐馆的收银台记录
     * @param rId 餐馆Id
     * @return 该餐馆的收银台对象
     */
    Cashier selectByRId(Integer rId);

    /**
     * 选择性更新收银台记录，只更新非空属性对应的字段
     * @param record 收银台记录
     * @return 更新数目
     */
    int updateByPrimaryKeySelective(Cashier record);

    /**
     * 更新收银台记录，更新所有属性对应的字段
     * @param record
     * @return
     */
    int updateByPrimaryKey(Cashier record);
}