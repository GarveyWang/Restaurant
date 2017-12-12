package com.restaurant.service.impl;

import com.restaurant.dao.DishDao;
import com.restaurant.dao.DishGroupDao;
import com.restaurant.entity.DiningTable;
import com.restaurant.entity.DishGroup;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("dishGroupService")
public class DishGroupServiceImpl implements com.restaurant.service.DishGroupService {
    @Resource
    private DishGroupDao dishGroupDao;

    @Resource
    private DishDao dishDao;

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

    @Override
    public int getDishCount(List<DishGroup> dishGroupList) {
        int count=0;
        for(DishGroup dishGroup: dishGroupList){
            count+=dishGroup.getDishes().size();
        }
        return count;
    }

    @Override
    public int getRIdByDgId(int dgId) {
        DishGroup dishGroup=dishGroupDao.selectByPrimaryKey(dgId);
        if(dishGroup==null){
            return -1;
        }else {
            return dishGroup.getrId();
        }
    }

    @Override
    public RegisterStateEnum register(DishGroup dishGroup) {
        if(dishGroup==null||dishGroup.getName()==null||"".equals(dishGroup.getName().trim())){
            return RegisterStateEnum.FAILED;
        }
        int insertCount=dishGroupDao.insertSelective(dishGroup);
        if(insertCount==1){
            return RegisterStateEnum.SUCCESS;
        }else {
            return RegisterStateEnum.FAILED;
        }
    }

    @Override
    public DeleteStateEnum deleteByDgId(int dgId) {
        dishDao.deleteByDgId(dgId);
        int deleteCount = dishGroupDao.deleteByPrimaryKey(dgId);
        if(deleteCount==1){
            return DeleteStateEnum.SUCCESS;
        }else {
            return DeleteStateEnum.FAILED;
        }
    }

    @Override
    public DishGroup selectById(int dgId) {
        return dishGroupDao.selectByPrimaryKey(dgId);
    }

    @Override
    public UpdateStateEnum update(DishGroup dishGroup) {
        if(dishGroup==null|| dishGroup.getName()==null || "".equals(dishGroup.getName().trim())){
            return UpdateStateEnum.FAILED;
        }
        int updateCount = dishGroupDao.updateByPrimaryKey(dishGroup);
        if(updateCount==1){
            return UpdateStateEnum.SUCCESS;
        }else {
            return UpdateStateEnum.FAILED;
        }
    }
}
