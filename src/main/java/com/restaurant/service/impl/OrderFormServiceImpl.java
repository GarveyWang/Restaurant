package com.restaurant.service.impl;

import com.restaurant.dao.OrderFormDao;
import com.restaurant.entity.OrderForm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderFormServiceImpl implements com.restaurant.service.OrderFormService {
    @Resource
    private OrderFormDao orderFormDao;

    @Override
    public int insertSelective(OrderForm record) {
        return orderFormDao.insertSelective(record);
    }

    @Override
    public OrderForm selectNotEndByTId(int tId) {
        return orderFormDao.selectNotEndByTId(tId);
    }

    @Override
    public List<OrderForm> selectNotEndByRId(int rId) {
        return orderFormDao.selectNotEndByRId(rId);
    }
}
