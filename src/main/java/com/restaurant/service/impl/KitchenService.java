package com.restaurant.service.impl;

import com.restaurant.dao.IKitchenDao;
import com.restaurant.model.Kitchen;
import com.restaurant.service.IKitchenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("kitchenService")
public class KitchenService implements IKitchenService {
    @Resource
    private IKitchenDao kitchenDao;

    @Override
    public int insertSelective(Kitchen record) {
        return kitchenDao.insertSelective(record);
    }
}
