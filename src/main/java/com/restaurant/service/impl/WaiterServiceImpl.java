package com.restaurant.service.impl;

import com.restaurant.dao.WaiterDao;
import com.restaurant.entity.Waiter;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service("waiterService")
public class WaiterServiceImpl implements com.restaurant.service.WaiterService {
    @Resource
    private WaiterDao waiterDao;

    @Override
    public int insertSelective(Waiter record){
        return waiterDao.insertSelective(record);
    }

    @Override
    public List<Waiter> selectByRId(int rId) {
        return waiterDao.selectByRId(rId);
    }

    @Override
    public Waiter selectById(int wId) {
        return waiterDao.selectById(wId);
    }

    @Override
    public LoginStateEnum validate(Waiter waiter) {
        if(waiter ==null|| waiter.getwId()==null||"".equals(waiter.getwId())
                || waiter.getPassword()==null||"".equals(waiter.getPassword())){
            return LoginStateEnum.IMCOMPLETE;
        }
        Waiter waiterFromDB=waiterDao.selectById(waiter.getwId());
        if( waiterFromDB==null|| !waiterFromDB.getPassword().equals(waiter.getPassword())){
            return LoginStateEnum.INFO_ERROR;
        }
        waiter.setrId(waiterFromDB.getrId());
        return LoginStateEnum.SUCCESS;
    }

    @Override
    public RegisterStateEnum register(Waiter waiter) {
        if(waiter ==null|| waiter.getName()==null||"".equals(waiter.getName().trim())
                || waiter.getPassword()==null||"".equals(waiter.getPassword().trim())) {
            return RegisterStateEnum.IMCOMPLETE;
        }
        int insertCount= waiterDao.insertSelective(waiter);
        if(insertCount==1){
            return RegisterStateEnum.SUCCESS;
        }else{
            return RegisterStateEnum.FAILED;
        }
    }



    @Override
    public int getRIdByWId(int wId) {
        Waiter waiter=waiterDao.selectById(wId);
        if(waiter==null){
            return -1;
        }else {
            return waiter.getrId();
        }
    }

    @Override
    public DeleteStateEnum deleteById(int wId) {
        int deleteCount = waiterDao.deleteById(wId);
        if(deleteCount==1){
            return DeleteStateEnum.SUCCESS;
        }else{
            return DeleteStateEnum.FAILED;
        }
    }

    @Override
    public UpdateStateEnum update(Waiter waiter) {
        if(waiter ==null|| waiter.getName()==null||"".equals(waiter.getName().trim())
                || waiter.getPassword()==null||"".equals(waiter.getPassword().trim())) {
            return UpdateStateEnum.FAILED;
        }

        int updateCount = waiterDao.updateByPrimaryKey(waiter);
        if(updateCount==1){
            return UpdateStateEnum.SUCCESS;
        }else{
            return UpdateStateEnum.FAILED;
        }
    }
}
