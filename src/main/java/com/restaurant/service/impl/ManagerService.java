package com.restaurant.service.impl;

import com.restaurant.dao.IManagerDao;
import com.restaurant.model.Manager;
import com.restaurant.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

@Service("managerService")
public class ManagerService implements IManagerService {
    @Resource
    private IManagerDao managerDao;

    @Override
    public Manager selectManager(int id) {
        return managerDao.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Manager record) {
        return managerDao.insertSelective(record);
    }
}
