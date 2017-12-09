package com.restaurant.service.impl;

import com.restaurant.dao.KitchenDao;
import com.restaurant.entity.Kitchen;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("kitchenService")
public class KitchenServiceImpl implements com.restaurant.service.KitchenService {
    @Resource
    private KitchenDao kitchenDao;

    @Override
    public int insertSelective(Kitchen record) {
        return kitchenDao.insertSelective(record);
    }

    @Override
    public List<Kitchen> selectByRId(int rId) {
        return kitchenDao.selectByRId(rId);
    }
}
