package com.restaurant.service;

import com.restaurant.dto.OrderFormItem;
import com.restaurant.entity.OrderDish;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;

/**
 * 点单服务类
 */
public interface OrderDishService {
    int insert(OrderDish record);

    List<OrderFormItem> selectOrderFormItemByOId(int oId);

    RegisterStateEnum register(OrderDish orderDish);

    DeleteStateEnum delete(int oId, int dId);

    UpdateStateEnum update(OrderDish orderDish);

    UpdateStateEnum cook(OrderDish orderDish);

    UpdateStateEnum serve(OrderDish orderDish);

}
