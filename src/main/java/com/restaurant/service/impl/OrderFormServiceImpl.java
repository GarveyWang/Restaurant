package com.restaurant.service.impl;

import com.restaurant.dao.DiningTableDao;
import com.restaurant.dao.DishDao;
import com.restaurant.dao.OrderDishDao;
import com.restaurant.dao.OrderFormDao;
import com.restaurant.entity.DiningTable;
import com.restaurant.entity.Dish;
import com.restaurant.entity.OrderDish;
import com.restaurant.entity.OrderForm;
import com.restaurant.enums.OrderFormStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.TableStateEnum;
import com.restaurant.enums.UpdateStateEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service("orderService")
public class OrderFormServiceImpl implements com.restaurant.service.OrderFormService {
    @Resource
    private OrderFormDao orderFormDao;

    @Resource
    private OrderDishDao orderDishDao;

    @Resource
    private DishDao dishDao;

    @Resource
    private DiningTableDao diningTableDao;

    @Override
    public int insertSelective(OrderForm record) {
        return orderFormDao.insertSelective(record);
    }

    @Override
    public OrderForm selectNotEndByTId(int tId) {
        return orderFormDao.selectNotEndByTId(tId);
    }

    @Override
    public List<OrderForm> selectNotEndByRId(int rId) {
        return orderFormDao.selectNotEndByRId(rId);
    }

    @Override
    public RegisterStateEnum register(int rId, int tId) {
        OrderForm orderForm=new OrderForm();
        orderForm.settId(tId);
        orderForm.setrId(rId);
        orderForm.setDiscount(1.0f);
        orderForm.setTotalPrice(0);
        orderForm.setSubmitTime(new Date());
        orderForm.setStatus(OrderFormStateEnum.NOT_END.getStateInfo());
        int insertCount = orderFormDao.insertSelective(orderForm);
        if(insertCount==1){
            return RegisterStateEnum.SUCCESS;
        }else {
            return RegisterStateEnum.FAILED;
        }
    }

    @Override
    public UpdateStateEnum end(OrderForm orderForm) {
        if(orderForm==null || orderForm.getoId()==null){
            return UpdateStateEnum.FAILED;
        }
        orderForm.setStatus(OrderFormStateEnum.END.getStateInfo());
        int updateCount=orderFormDao.updateByPrimaryKeySelective(orderForm);
        if(updateCount==1){
            int tId = orderForm.gettId();
            DiningTable table=diningTableDao.selectById(tId);
            table.setStatus(TableStateEnum.FREE.getStateInfo());
            table.setGuestNumber(0);

            int serviceCode=new Random().nextInt(1000);
            table.setServiceCode(String.valueOf(serviceCode));
            diningTableDao.updateByPrimaryKeySelective(table);

            return UpdateStateEnum.SUCCESS;
        }else {
            return UpdateStateEnum.FAILED;
        }
    }

    @Override
    public int countTotalPrice(int oId) {
        int totalPrice=0;
        List<OrderDish> orderDishList=orderDishDao.selectByOId(oId);
        for (OrderDish orderDish:orderDishList){
            Dish dish = dishDao.selectById(orderDish.getdId());
            if(dish!=null){
                totalPrice+=dish.getPrice()*orderDish.getOrderNumber();
            }
        }
        OrderForm orderForm = orderFormDao.selectById(oId);
        if(orderForm!=null){
            orderForm.setTotalPrice(totalPrice);
            orderFormDao.updateByPrimaryKey(orderForm);
        }
        return totalPrice;
    }

    @Override
    public int getTotalPrice(int oId) {
        int totalPrice=0;
        OrderForm orderForm = orderFormDao.selectById(oId);
        if(orderForm!=null){
            totalPrice=orderForm.getTotalPrice();
        }
        return totalPrice;
    }
}
