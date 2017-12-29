package com.restaurant.service;

import com.restaurant.entity.OrderForm;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;

/**
 * 订单服务类
 */
public interface OrderFormService {
    /**
     * 选择性插入订单记录，允许部分属性为空
     * @param record 订单记录
     * @return 插入数目
     */
    int insertSelective(OrderForm record);

    /**
     * 选取指定id的餐桌上正在进行的订单对象
     * @param tId 餐桌Id
     * @return 订单对象
     */
    OrderForm selectNotEndByTId(int tId);

    /**
     * 通过餐馆Id获取该餐馆当前还未结束的订单
     * @param rId 餐馆Id
     * @return 订单List
     */
    List<OrderForm> selectNotEndByRId(int rId);

    /**
     * 根据餐馆Id，餐桌Id新建订单
     * @param rId 餐馆id
     * @param tId 餐桌Id
     * @return 新建状态
     */
    RegisterStateEnum register(int rId, int tId);

    /**
     * 结束订单
     * @param orderForm 订单对象
     * @return 更新状态
     */
    UpdateStateEnum end(OrderForm orderForm);

    /**
     * 计算指定Id的订单的消费价格
     * @param oId 订单Id
     * @return 消费价格
     */
    int countTotalPrice(int oId);

    /**
     * 获取指定Id的订单的消费价格
     * @param oId 订单Id
     * @return 消费价格
     */
    int getTotalPrice(int oId);
}
