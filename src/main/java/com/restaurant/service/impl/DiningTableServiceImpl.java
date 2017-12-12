package com.restaurant.service.impl;

import com.restaurant.dao.DiningTableDao;
import com.restaurant.dao.TableGroupDao;
import com.restaurant.entity.DiningTable;
import com.restaurant.entity.TableGroup;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("diningTableService")
public class DiningTableServiceImpl implements com.restaurant.service.DiningTableService {
    @Resource
    private DiningTableDao diningTableDao;

    @Resource
    private TableGroupDao tableGroupDao;

    @Override
    public int insertSelective(DiningTable record) {
        return diningTableDao.insertSelective(record);
    }

    @Override
    public List<DiningTable> selectByTgId(int tgId) {
        return diningTableDao.selectByTgId(tgId);
    }

    @Override
    public DiningTable selectById(int tId) {
        return diningTableDao.selectById(tId);
    }

    @Override
    public LoginStateEnum validate(DiningTable table) {
        if(table==null||table.gettId()==null||"".equals(table.gettId())
                ||table.getServiceCode()==null||"".equals(table.getServiceCode().trim())){
            return LoginStateEnum.IMCOMPLETE;
        }

        int tId=table.gettId();
        String serviceCode=table.getServiceCode();

        //比对数据库，如果账号不存在或者密码错误，返回并提示
        DiningTable tableFromDB=diningTableDao.selectById(tId);
        if(tableFromDB==null||
                !tableFromDB.getServiceCode().equals(serviceCode)){
            return LoginStateEnum.INFO_ERROR;
        }

        table.setTgId(tableFromDB.getTgId());
        return LoginStateEnum.SUCCESS;
    }

    @Override
    public RegisterStateEnum register(DiningTable table) {
        if(table==null||table.getName()==null||"".equals(table.getName().trim())
                ||table.getCapacity()==null|| table.getCapacity()<=0){
            return RegisterStateEnum.FAILED;
        }
        int insertCount=diningTableDao.insertSelective(table);
        if(insertCount==1){
            return RegisterStateEnum.SUCCESS;
        }
        else {
            return RegisterStateEnum.FAILED;
        }
    }

    @Override
    public int getRIdByTId(int tId) {
        DiningTable diningTable=diningTableDao.selectById(tId);
        if(diningTable==null){
            return -1;
        }else {
            TableGroup tableGroup=tableGroupDao.selectById(diningTable.getTgId());
            return tableGroup.getrId();
        }
    }

    @Override
    public DeleteStateEnum deleteById(int tId) {
        int deleteCount=diningTableDao.deleteByPrimaryKey(tId);
        if(deleteCount==1){
            return DeleteStateEnum.SUCCESS;
        }else {
            return DeleteStateEnum.FAILED;
        }
    }

    @Override
    public void deleteByTgId(int tgId) {
        diningTableDao.deleteByTgId(tgId);
    }

    @Override
    public UpdateStateEnum updateSelective(DiningTable table) {
        if(table==null|| table.getName()==null|| "".equals(table.getName().trim())||
                table.getServiceCode()==null || "".equals(table.getServiceCode().trim())){
            return UpdateStateEnum.FAILED;
        }
        int updateCount=diningTableDao.updateByPrimaryKeySelective(table);
        if(updateCount==1){
            return UpdateStateEnum.SUCCESS;
        }else{
            return UpdateStateEnum.FAILED;
        }
    }

    @Override
    public UpdateStateEnum updateGuestInfo(DiningTable table) {
        if(table==null || table.getServiceCode()==null || "".equals(table.getServiceCode().trim())){
            return UpdateStateEnum.FAILED;
        }
        int updateCount=diningTableDao.updateByPrimaryKeySelective(table);
        if(updateCount==1){
            return UpdateStateEnum.SUCCESS;
        }else{
            return UpdateStateEnum.FAILED;
        }
    }
}
