package com.restaurant.service.impl;

import com.restaurant.dao.DiningTableDao;
import com.restaurant.dao.TableGroupDao;
import com.restaurant.entity.TableGroup;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tableGroupService")
public class TableGroupServiceImpl implements com.restaurant.service.TableGroupService {
    @Resource
    private TableGroupDao tableGroupDao;

    @Resource
    private DiningTableDao diningTableDao;

    @Override
    public int insertSelective(TableGroup record) {
        return tableGroupDao.insertSelective(record);
    }

    @Override
    public int insert(TableGroup record){
        return tableGroupDao.insert(record);
    }

    @Override
    public TableGroup selectById(int tgId) {
        return tableGroupDao.selectById(tgId);
    }

    @Override
    public List<TableGroup> selectByRId(int rId) {
        return tableGroupDao.selectByRId(rId);
    }

    @Override
    public RegisterStateEnum register(TableGroup tableGroup) {
        if(tableGroup.getName()==null|| "".equals(tableGroup.getName().trim())){
            return RegisterStateEnum.FAILED;
        }
        int insertCount=tableGroupDao.insertSelective(tableGroup);
        if(insertCount==1){
            return RegisterStateEnum.SUCCESS;
        }else{
            return RegisterStateEnum.FAILED;
        }
    }

    @Override
    public int getTableCount(List<TableGroup> tableGroupList) {
        int count=0;
        for(TableGroup tableGroup:tableGroupList){
            count+=tableGroup.getDiningTables().size();
        }
        return count;
    }

    @Override
    public int getRIdByTgId(int tgId) {
        TableGroup tableGroup=tableGroupDao.selectById(tgId);
        if(tableGroup==null){
            return -1;
        }else {
            return tableGroup.getrId();
        }
    }

    @Override
    public DeleteStateEnum deleteByTgId(int tgId) {
        diningTableDao.deleteByTgId(tgId);
        int deleteCount = tableGroupDao.deleteByPrimaryKey(tgId);
        if(deleteCount==1){
            return DeleteStateEnum.SUCCESS;
        }
        else {
            return DeleteStateEnum.FAILED;
        }
    }

    @Override
    public UpdateStateEnum update(TableGroup tableGroup) {
        if(tableGroup ==null|| tableGroup.getName()==null||"".equals(tableGroup.getName().trim())) {
            return UpdateStateEnum.FAILED;
        }
        int updateCount=tableGroupDao.updateByPrimaryKey(tableGroup);
        if(updateCount==1){
            return UpdateStateEnum.SUCCESS;
        }else{
            return UpdateStateEnum.FAILED;
        }
    }
}
