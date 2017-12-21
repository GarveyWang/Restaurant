package com.restaurant.service.impl;

import com.restaurant.dao.DishDao;
import com.restaurant.dao.OrderDishDao;
import com.restaurant.dao.OrderFormDao;
import com.restaurant.dto.OrderFormItem;
import com.restaurant.entity.Dish;
import com.restaurant.entity.OrderDish;
import com.restaurant.entity.OrderDishKey;
import com.restaurant.entity.OrderForm;
import com.restaurant.enums.*;
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
    public List<OrderFormItem> selectOrderFormItemByOId(int oId) {
        List<OrderFormItem> orderFormItemList=new ArrayList<OrderFormItem>();
        List<OrderDish> orderDishList=orderDishDao.selectByOId(oId);
        for(OrderDish orderDish:orderDishList){
            int d_id=orderDish.getdId();
            Dish dish=dishDao.selectById(d_id);
            if(dish!=null){
                String dishName=dish.getName();
                int price=dish.getPrice();
                OrderFormItem orderFormItem=new OrderFormItem(d_id,orderDish.getOrderNumber(),orderDish.getServeNumber(),
                        orderDish.getRemark(),orderDish.getStatus(),orderDish.getOrderTime(),orderDish.getScore());
                orderFormItem.setName(dishName);
                orderFormItem.setPrice(price);
                orderFormItemList.add(orderFormItem);
            }
        }
        return orderFormItemList;
    }

    @Override
    public RegisterStateEnum register(OrderDish orderDish) {
        if(orderDish==null){
            return RegisterStateEnum.FAILED;
        }

        Dish dish = dishDao.selectById(orderDish.getdId());
        if(dish==null||dish.getStatus().equals(MenuItemStateEnum.SOLD_OUT.getStateInfo())){
            return RegisterStateEnum.FAILED;
        }

        orderDish.setServeNumber(0);
        orderDish.setOrderTime(new Date());
        orderDish.setScore(5);
        orderDish.setStatus(OrderDishStateEnum.WAITING.getStateInfo());

        int insertCount = orderDishDao.insert(orderDish);
        if(insertCount==1){
            return RegisterStateEnum.SUCCESS;
        }else {
            return RegisterStateEnum.FAILED;
        }
    }

    @Override
    public DeleteStateEnum delete(int oId, int dId) {
        OrderDishKey key=new OrderDishKey(oId,dId);
        OrderDish orderDish=orderDishDao.selectByPrimaryKey(key);
        if(orderDish==null|| !orderDish.getStatus().equals(OrderDishStateEnum.WAITING.getStateInfo())
                ||orderDish.getServeNumber()!=0){
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

        int orderNumber=orderDish.getOrderNumber();
        int orderNumberFromDB=orderDishFromDB.getOrderNumber();
        int serveNumberFromDB=orderDishFromDB.getServeNumber();

        //如果修改了点菜数量
        if(orderNumber!=orderNumberFromDB){
            //如果修改后的数量小于已经上菜的数量，则失败
            if(orderNumber < serveNumberFromDB){
                return UpdateStateEnum.FAILED;
            }
            //如果修改后的数量大于已经上菜的数量，即顾客添加点菜数量
            else if(orderNumber > serveNumberFromDB) {
                //将“已上菜”状态修改为“排队中”。“正在烹饪”不修改
                if (orderDishFromDB.getStatus().equals(OrderDishStateEnum.END.getStateInfo())) {
                    orderDish.setStatus(OrderDishStateEnum.WAITING.getStateInfo());
                }
            }
            //如果修改后的数量等于已经上菜的数量
            else {
                //但是状态为“正在烹饪”，说明后厨还在煮该菜，修改会失败
                if(orderDishFromDB.getStatus().equals(OrderDishStateEnum.COOKING.getStateInfo())){
                    return UpdateStateEnum.FAILED;
                }
                //将状态修改为已上菜
                orderDish.setStatus(OrderDishStateEnum.END.getStateInfo());
            }
        }
        //这是没有修改点单数量，但是修改了备注的情况。如果菜已经上了，或者正在烹饪，这时候的备注无法被后厨看到
        //为了避免不必要的麻烦，需要拒绝这种更新请求
        else {
            if(!orderDishFromDB.getStatus().equals(OrderDishStateEnum.WAITING.getStateInfo())){
                return UpdateStateEnum.FAILED;
            }
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
