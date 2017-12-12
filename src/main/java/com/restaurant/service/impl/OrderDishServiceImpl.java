package com.restaurant.service.impl;

import com.restaurant.dao.DishDao;
import com.restaurant.dao.OrderDishDao;
import com.restaurant.dto.OrderFormItem;
import com.restaurant.entity.Dish;
import com.restaurant.entity.OrderDish;
import com.restaurant.entity.OrderDishKey;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.OrderDishStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("orderDishService")
public class OrderDishServiceImpl implements com.restaurant.service.OrderDishService {
    @Resource
    private OrderDishDao orderDishDao;

    @Resource
    private DishDao dishDao;

    @Override
    public int insert(OrderDish record) {
        return orderDishDao.insert(record);
    }

    @Override
    public List<OrderDish> selectByOId(int oId) {
        return orderDishDao.selectByOId(oId);
    }

    @Override
    public List<OrderDish> selectNotEndByOId(int oId) {
        return orderDishDao.selectNotEndByOId(oId);
    }

    @Override
    public List<OrderFormItem> selectOrderFormItemByOId(int oId) {
        List<OrderFormItem> orderFormItemList=new ArrayList<OrderFormItem>();
        List<OrderDish> orderDishList=orderDishDao.selectByOId(oId);
        for(OrderDish orderDish:orderDishList){
            int d_id=orderDish.getdId();
            Dish dish=dishDao.selectById(d_id);
            String dishName=dish.getName();
            int price=dish.getPrice();
            OrderFormItem orderFormItem=new OrderFormItem(d_id,orderDish.getOrderNumber(),orderDish.getServeNumber(),orderDish.getRemark(),orderDish.getStatus(),orderDish.getOrderTime());
            orderFormItem.setName(dishName);
            orderFormItem.setPrice(price);
            orderFormItemList.add(orderFormItem);
        }
        return orderFormItemList;
    }

    @Override
    public RegisterStateEnum register(OrderDish orderDish) {
        if(orderDish==null){
            return RegisterStateEnum.FAILED;
        }

        orderDish.setServeNumber(0);
        orderDish.setOrderTime(new Date());
        orderDish.setStatus(OrderDishStateEnum.WAITING.getStateInfo());

        int insertCount = orderDishDao.insert(orderDish);
        if(insertCount==1){
            return RegisterStateEnum.SUCCESS;
        }else {
            return RegisterStateEnum.FAILED;
        }
    }

    @Override
    public DeleteStateEnum deleteByPrimaryKey(int oId, int dId) {
        OrderDishKey key=new OrderDishKey(oId,dId);
        OrderDish orderDish=orderDishDao.selectByPrimaryKey(key);
        if(orderDish==null|| !orderDish.getStatus().equals(OrderDishStateEnum.WAITING.getStateInfo())){
            return DeleteStateEnum.FAILED;
        }
        int deleteCount=orderDishDao.deleteByPrimaryKey(key);
        if(deleteCount==1){
            return DeleteStateEnum.SUCCESS;
        }else {
            return DeleteStateEnum.FAILED;
        }
    }

    @Override
    public UpdateStateEnum update(OrderDish orderDish) {
        OrderDishKey key=new OrderDishKey(orderDish.getoId(),orderDish.getdId());
        OrderDish orderDishFromDB=orderDishDao.selectByPrimaryKey(key);

        if(orderDish.getOrderNumber() < orderDishFromDB.getServeNumber()){
            return UpdateStateEnum.FAILED;
        }
        if(orderDish.getOrderNumber() == orderDishFromDB.getServeNumber()
                && orderDishFromDB.getStatus().equals(OrderDishStateEnum.COOKING.getStateInfo())){
            return UpdateStateEnum.FAILED;
        }

        if(orderDish.getOrderNumber() == orderDishFromDB.getServeNumber()
                && orderDishFromDB.getStatus().equals(OrderDishStateEnum.WAITING.getStateInfo())){
            orderDish.setStatus(OrderDishStateEnum.END.getStateInfo());
        }

        int updateCount = orderDishDao.updateByPrimaryKeySelective(orderDish);
        if(updateCount==1){
            return UpdateStateEnum.SUCCESS;
        }else {
            return UpdateStateEnum.FAILED;
        }

    }

    @Override
    public UpdateStateEnum cook(OrderDish orderDish) {
        OrderDishKey key=new OrderDishKey(orderDish.getoId(),orderDish.getdId());
        OrderDish orderDishFromDB=orderDishDao.selectByPrimaryKey(key);

        if(orderDishFromDB.getOrderNumber()==orderDishFromDB.getServeNumber()){
            return UpdateStateEnum.FAILED;
        }
        orderDish.setStatus(OrderDishStateEnum.COOKING.getStateInfo());
        int updateCount=orderDishDao.updateByPrimaryKeySelective(orderDish);
        if(updateCount==1){
            return UpdateStateEnum.SUCCESS;
        }else {
            return UpdateStateEnum.FAILED;
        }
    }

    @Override
    public UpdateStateEnum serve(OrderDish orderDish) {
        OrderDishKey key=new OrderDishKey(orderDish.getoId(),orderDish.getdId());
        int updateCount = orderDishDao.addServeNumber(key);
        if(updateCount < 1){
            return UpdateStateEnum.FAILED;
        }

        OrderDish orderDishFromDB=orderDishDao.selectByPrimaryKey(key);
        if(orderDishFromDB.getOrderNumber()==orderDishFromDB.getServeNumber()){
            orderDish.setStatus(OrderDishStateEnum.END.getStateInfo());
        }else {
            orderDish.setStatus(OrderDishStateEnum.WAITING.getStateInfo());
        }
        orderDishDao.updateByPrimaryKeySelective(orderDish);
        return UpdateStateEnum.SUCCESS;
    }
}
