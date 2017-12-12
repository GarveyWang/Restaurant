package com.restaurant.service;

import com.restaurant.dto.OrderFormItem;
import com.restaurant.entity.OrderDish;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;

public interface OrderDishService {
    int insert(OrderDish record);

    List<OrderDish> selectByOId(int oId);

    List<OrderDish> selectNotEndByOId(int old);

    List<OrderFormItem> selectOrderFormItemByOId(int oId);

    RegisterStateEnum register(OrderDish orderDish);

    DeleteStateEnum deleteByPrimaryKey(int oId, int dId);

    UpdateStateEnum update(OrderDish orderDish);

    UpdateStateEnum cook(OrderDish orderDish);

    UpdateStateEnum serve(OrderDish orderDish);

}
