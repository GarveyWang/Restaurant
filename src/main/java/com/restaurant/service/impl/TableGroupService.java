package com.restaurant.service.impl;

import com.restaurant.dao.ITableGroupDao;
import com.restaurant.model.TableGroup;
import com.restaurant.service.ITableGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("groupService")
public class TableGroupService implements ITableGroupService {
    @Resource
    private ITableGroupDao groupDao;

    @Override
    public int insertSelective(TableGroup record) {
        return groupDao.insertSelective(record);
    }

    @Override
    public int insert(TableGroup record){
        return groupDao.insert(record);
    }
}
