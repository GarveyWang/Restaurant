package com.restaurant.dao;

import com.restaurant.dto.SoldDishItem;
import com.restaurant.entity.Dish;

import java.util.Date;
import java.util.List;

public interface DishDao {
    /**
     * 通过菜品Id删除对应菜品记录
     * @param dId 菜品Id
     * @return 删除数目
     */
    int deleteByPrimaryKey(Integer dId);

    /**
     * 删除指定菜品组下所有菜品记录
     * @param dgId 菜品组Id
     * @return 删除数目
     */
    int deleteByDgId(Integer dgId);

    /**
     * 插入菜品记录
     * @param record 菜品记录
     * @return 插入数目
     */
    int insert(Dish record);

    /**
     * 选择性插入菜品记录，允许部分字段为空
     * @param record 菜品记录
     * @return 插入数目
     */
    int insertSelective(Dish record);

    /**
     * 通过菜品Id查询指定菜品记录
     * @param dId 菜品Id
     * @return 指定Id的菜品对象
     */
    Dish selectById(Integer dId);

    /**
     * 通过菜品组Id查询该菜品组下所有的菜品记录
     * @param dgId 菜品组Id
     * @return 该菜品组下所有的菜品List
     */
    List<Dish> selectByDgId(Integer dgId);

    /**
     * 通过主键选择性更新菜品记录，仅更新非空属性对应的字段
     * @param record 菜品记录
     * @return 更新数目
     */
    int updateByPrimaryKeySelective(Dish record);

    /**
     * 通过主键选择性更新菜品记录，更新所有字段
     * @param record 菜品记录
     * @return 更新数目
     */
    int updateByPrimaryKey(Dish record);

    /**
     * 选取指定日期以来，指定餐馆，销售最高的前5个菜品
     * @param rId 餐馆Id
     * @param date 起始日期
     * @return 菜品销售记录Top5的List
     */
    List<SoldDishItem> selectTop5SoldDishes (int rId, Date date);
}