package com.restaurant.service.impl;

import com.restaurant.dao.*;
import com.restaurant.dto.KitchenTaskItem;
import com.restaurant.entity.*;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("kitchenService")
public class KitchenServiceImpl implements com.restaurant.service.KitchenService {
    @Resource
    private KitchenDao kitchenDao;

    @Resource
    public OrderFormDao orderFormDao;

    @Resource
    public DiningTableDao diningTableDao;

    @Resource
    public TableGroupDao tableGroupDao;

    @Resource
    public OrderDishDao orderDishDao;

    @Resource
    public DishDao dishDao;

    @Override
    public int insertSelective(Kitchen record) {
        return kitchenDao.insertSelective(record);
    }

    @Override
    public List<Kitchen> selectByRId(int rId) {
        return kitchenDao.selectByRId(rId);
    }

    @Override
    public Kitchen selectById(int Id) {
        return kitchenDao.selectById(Id);
    }

    @Override
    public LoginStateEnum validate(Kitchen kitchen) {
        if(kitchen==null||kitchen.getkId()==null||"".equals(kitchen.getkId())
                ||kitchen.getPassword()==null||"".equals(kitchen.getPassword())){
            return LoginStateEnum.IMCOMPLETE;
        }

        //比对数据库，如果账号不存在或者密码错误，返回并提示
        Kitchen kitchenFromDB=kitchenDao.selectById(kitchen.getkId());
        if(kitchenFromDB==null||!kitchenFromDB.getPassword().equals(kitchen.getPassword())){
            return LoginStateEnum.INFO_ERROR;
        }

        kitchen.setrId(kitchenFromDB.getrId());
        return LoginStateEnum.SUCCESS;
    }

    @Override
    public List<KitchenTaskItem> selectTaskByRId(int rId) {
        List<KitchenTaskItem> kitchenTaskItemList=new ArrayList<KitchenTaskItem>();

        List<OrderForm> OrderFormList=orderFormDao.selectNotEndByRId(rId);
        for(OrderForm orderForm:OrderFormList){
            int oId=orderForm.getoId();
            int tId=orderForm.gettId();
            String tableName=null;
            String tableGroupName=null;
            DiningTable table=diningTableDao.selectById(tId);
            if(table!=null){
                tableName=table.getName();
                TableGroup tableGroup=tableGroupDao.selectById(table.getTgId());
                tableGroupName=tableGroup.getName();
            }else{
                tableName="-";
                tableGroupName="-";
            }

            List<OrderDish> orderDishList=orderDishDao.selectNotEndByOId(oId);
            for(OrderDish orderDish:orderDishList){
                int dId=orderDish.getdId();
                KitchenTaskItem item=new KitchenTaskItem(orderDish.getoId(),dId,orderDish.getOrderNumber(),orderDish.getServeNumber(),orderDish.getRemark(),orderDish.getOrderTime(),orderDish.getStatus());
                Dish dish=dishDao.selectById(dId);
                if(dish!=null){
                    item.setDishName(dish.getName());
                    item.setTableName(tableName);
                    item.setTableGroupName(tableGroupName);
                    kitchenTaskItemList.add(item);
                }
            }
        }
        return kitchenTaskItemList;
    }

    @Override
    public RegisterStateEnum register(Kitchen kitchen) {
        if(kitchen ==null|| kitchen.getName()==null||"".equals(kitchen.getName().trim())
                || kitchen.getPassword()==null||"".equals(kitchen.getPassword().trim())) {
            return RegisterStateEnum.IMCOMPLETE;
        }
        int insertCount= kitchenDao.insertSelective(kitchen);
        if(insertCount==1){
            return RegisterStateEnum.SUCCESS;
        }else{
            return RegisterStateEnum.FAILED;
        }
    }

    @Override
    public int getRIdByKId(int kId) {
        Kitchen kitchen=kitchenDao.selectById(kId);
        if(kitchen==null){
            return -1;
        }else {
            return kitchen.getrId();
        }
    }

    @Override
    public DeleteStateEnum deleteById(int kId) {
        int deleteCount = kitchenDao.deleteById(kId);
        if(deleteCount==1){
            return DeleteStateEnum.SUCCESS;
        }else{
            return DeleteStateEnum.FAILED;
        }
    }

    @Override
    public UpdateStateEnum update(Kitchen kitchen) {
        if(kitchen ==null|| kitchen.getName()==null||"".equals(kitchen.getName().trim())
                || kitchen.getPassword()==null||"".equals(kitchen.getPassword().trim())) {
            return UpdateStateEnum.FAILED;
        }

        int updateCount = kitchenDao.updateByPrimaryKey(kitchen);
        if(updateCount==1){
            return UpdateStateEnum.SUCCESS;
        }else{
            return UpdateStateEnum.FAILED;
        }
    }
}
