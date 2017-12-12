package com.restaurant.service.impl;

import com.restaurant.dao.CashierDao;
import com.restaurant.entity.Cashier;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.UpdateStateEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("cashierService")
public class CashierServiceImpl implements com.restaurant.service.CashierService {

    @Resource
    private CashierDao cashierDao;

    @Override
    public int insertSelective(Cashier record) {
        return cashierDao.insertSelective(record);
    }

    @Override
    public Cashier selectByRId(int rId) {
        return cashierDao.selectByRId(rId);
    }

    @Override
    public Cashier selectById(int cId){
        return cashierDao.selectById(cId);
    }

    @Override
    public LoginStateEnum validate(Cashier cashier) {
        if(cashier==null||cashier.getcId()==null||"".equals(cashier.getcId())
                ||cashier.getPassword()==null||"".equals(cashier.getPassword())){
            return LoginStateEnum.IMCOMPLETE;
        }

        //比对数据库，如果账号不存在或者密码错误，返回并提示
        Cashier cashierFromDB=cashierDao.selectById(cashier.getcId());
        if(cashierFromDB==null||!cashierFromDB.getPassword().equals(cashier.getPassword())){
            return LoginStateEnum.INFO_ERROR;
        }

        cashier.setrId(cashierFromDB.getrId());
        return LoginStateEnum.SUCCESS;
    }

    @Override
    public void registerByRId(int rId) {
        Cashier cashier=new Cashier();
        cashier.setcId(rId);
        cashier.setActive(new Byte("1"));
        cashier.setrId(rId);
        cashier.setPassword("666666");
        cashierDao.insert(cashier);
    }

    @Override
    public UpdateStateEnum update(Cashier cashier) {
        if(cashier==null||cashier.getcId()==null||"".equals(cashier.getcId())
                ||cashier.getPassword()==null||"".equals(cashier.getPassword())){
            return UpdateStateEnum.FAILED;
        }

        int updateCount = cashierDao.updateByPrimaryKey(cashier);
        if(updateCount==1){
            return UpdateStateEnum.SUCCESS;
        }else{
            return UpdateStateEnum.FAILED;
        }
    }
}
