package com.restaurant.service;

import com.restaurant.dto.SoldDishItem;
import com.restaurant.entity.Dish;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;

/**
 * 菜品服务类
 */
public interface DishService {
    /**
     * 选择性插入菜品记录，允许部分属性为空
     * @param record 菜品记录
     * @return 插入数目
     */
    int insertSelective(Dish record);

    /**
     * 通过菜品Id获取对应菜品对象
     * @param dId 菜品id
     * @return 菜品对象
     */
    Dish selectById(Integer dId);

    /**
     * 新建菜品记录
     * @param dish 菜品对象
     * @return 新建状态
     */
    RegisterStateEnum register(Dish dish);

    /**
     * 通过菜品Id获取其所在的餐馆的Id
     * @param dId 菜品Id
     * @return 餐馆Id
     */
    int getRIdByDId(int dId);

    /**
     * 通过Id 删除对应的菜品记录
     * @param dId 菜品Id
     * @return 删除状态
     */
    DeleteStateEnum deleteById(int dId);

    /**
     * 更新菜品记录
     * @param dish 菜品激励
     * @return 更新状态
     */
    UpdateStateEnum update(Dish dish);

    /**
     * 获取指定餐馆前一个月销量最好的前五个菜品
     * @param rId 餐馆Id
     * @return 菜品售卖情况List
     */
    List<SoldDishItem> getTop5SoldDishes(int rId);

}
