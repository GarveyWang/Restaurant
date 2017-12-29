package com.restaurant.dao;

import com.restaurant.entity.Waiter;

import java.util.List;

/**
 * 服务员相关Dao
 */
public interface WaiterDao {
    /**
     * 通过服务员账号Id删除对应服务员账号记录
     * @param wId 服务员账号Id
     * @return 删除数目
     */
    int deleteById(Integer wId);

    /**
     * 插入服务员账号记录
     * @param record 服务员账号记录
     * @return 插入数目
     */
    int insert(Waiter record);

    /**
     * 选择性插入服务员账号记录，允许部分字段为空
     * @param record 服务员账号记录
     * @return 插入数目
     */
    int insertSelective(Waiter record);

    /**
     * 通过服务员账号Id查询指定服务员账号记录
     * @param wId 服务员账号Id
     * @return 指定Id的服务员账号对象
     */
    Waiter selectById(Integer wId);

    /**
     * 通过餐馆Id查询该餐馆下所有的服务员账号记录
     * @param rId 餐馆Id
     * @return 该餐馆下所有的服务员账号记录List
     */
    List<Waiter> selectByRId(Integer rId);

    /**
     * 通过主键选择性更新服务员账号记录，仅更新非空属性对应的字段
     * @param record 服务员账号记录
     * @return 更新数目
     */
    int updateByPrimaryKeySelective(Waiter record);

    /**
     * 通过主键更新服务员账号记录，更新所有字段
     * @param record 服务员账号记录
     * @return 更新数目
     */
    int updateByPrimaryKey(Waiter record);
}