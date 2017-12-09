package com.restaurant.service.impl;

import com.restaurant.dao.TableGroupDao;
import com.restaurant.entity.TableGroup;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("groupService")
public class TableGroupServiceImpl implements com.restaurant.service.TableGroupService {
    @Resource
    private TableGroupDao groupDao;

    @Override
    public int insertSelective(TableGroup record) {
        return groupDao.insertSelective(record);
    }

    @Override
    public int insert(TableGroup record){
        return groupDao.insert(record);
    }

    @Override
    public List<TableGroup> selectByRId(int rId) {
        return groupDao.selectByRId(rId);
    }
}
