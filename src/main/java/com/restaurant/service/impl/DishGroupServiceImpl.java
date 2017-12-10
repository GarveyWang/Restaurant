package com.restaurant.service.impl;

import com.restaurant.dao.DishGroupDao;
import com.restaurant.entity.DiningTable;
import com.restaurant.entity.DishGroup;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("dishGroupService")
public class DishGroupServiceImpl implements com.restaurant.service.DishGroupService {
    @Resource
    private DishGroupDao dishGroupDao;

    @Override
    public int insertSelective(DishGroup record) {
        return dishGroupDao.insertSelective(record);
    }

    @Override
    public int insert(DishGroup record){
        return dishGroupDao.insert(record);
    }

    @Override
    public List<DishGroup> selectByRId(int rId) {
        return dishGroupDao.selectByRId(rId);
    }
}
