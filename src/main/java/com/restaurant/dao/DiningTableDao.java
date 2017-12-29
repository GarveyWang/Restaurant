package com.restaurant.dao;

import com.restaurant.entity.DiningTable;

import java.util.List;

/**
 * 餐桌相关Dao
 */
public interface DiningTableDao {
    /**
     * 通过餐桌Id删除指定餐桌
     * @param tId 餐桌Id
     * @return 删除数目
     */
    int deleteByPrimaryKey(Integer tId);

    /**
     * 通过餐桌组Id删除该组下的所有餐桌
     * @param tgId 餐桌组Id
     * @return 删除数目
     */
    int deleteByTgId(Integer tgId);

    /**
     * 插入餐桌记录
     * @param record 餐桌记录
     * @return 插入数目
     */
    int insert(DiningTable record);

    /**
     * 插入餐桌记录，部分属性可为空
     * @param record 餐桌记录
     * @return 插入数目
     */
    int insertSelective(DiningTable record);

    /**
     * 通过餐桌Id查询指定餐桌
     * @param tId 餐桌Id
     * @return 指定Id的餐桌
     */
    DiningTable selectById(Integer tId);

    /**
     * 通过餐桌组Id查询该组下的所有餐桌
     * @param tgId 餐桌组Id
     * @return 指定餐桌组下的所有餐桌List
     */
    List<DiningTable> selectByTgId(Integer tgId);

    /**
     * 通过主键选择性更新餐桌记录，仅更新非空属性对应的字段
     * @param record 餐桌记录
     * @return 更新数目
     */
    int updateByPrimaryKeySelective(DiningTable record);

    /**
     * 通过主键更新餐桌记录，更新所有字段
     * @param record 餐桌记录
     * @return 更新数目
     */
    int updateByPrimaryKey(DiningTable record);
}