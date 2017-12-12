package com.restaurant.service.impl;

import com.restaurant.dao.OrderFormDao;
import com.restaurant.entity.OrderForm;
import com.restaurant.enums.OrderFormStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderFormServiceImpl implements com.restaurant.service.OrderFormService {
    @Resource
    private OrderFormDao orderFormDao;

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
            return UpdateStateEnum.SUCCESS;
        }else {
            return UpdateStateEnum.FAILED;
        }
    }
}
