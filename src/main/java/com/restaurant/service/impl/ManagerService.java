package com.restaurant.service.impl;

import com.restaurant.dao.IManagerDao;
import com.restaurant.model.Manager;
import com.restaurant.service.IManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("managerService")
public class ManagerService implements IManagerService {
    @Resource
    private IManagerDao managerDao;

    @Override
    public Manager selectManager(int id) {
        return this.managerDao.selectByPrimaryKey(id);
    }
}
