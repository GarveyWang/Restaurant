package com.restaurant.service.impl;

import com.restaurant.dao.DishDao;
import com.restaurant.dao.DishGroupDao;
import com.restaurant.dto.SoldDishItem;
import com.restaurant.entity.Dish;
import com.restaurant.entity.DishGroup;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;
import com.restaurant.service.DishGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service("dishService")
public class DishServiceImpl implements com.restaurant.service.DishService {
    @Resource
    private DishDao dishDao;

    @Resource
    private DishGroupDao dishGroupDao;

    @Override
    public int insertSelective(Dish record) {
        return dishDao.insertSelective(record);
    }

    @Override
    public Dish selectById(Integer dId) {
        return dishDao.selectById(dId);
    }

    @Override
    public RegisterStateEnum register(Dish dish) {
        int insertCount=dishDao.insertSelective(dish);
        if(insertCount==1){
            return RegisterStateEnum.SUCCESS;
        }else {
            return RegisterStateEnum.FAILED;
        }
    }

    @Override
    public int getRIdByDId(int dId) {
        Dish dish=dishDao.selectById(dId);
        if(dish!=null){
            DishGroup dishGroup=dishGroupDao.selectByPrimaryKey(dish.getDgId());
            return dishGroup.getrId();
        }else {
            return -1;
        }
    }

    @Override
    public DeleteStateEnum deleteById(int dId) {
        int deleteCount=dishDao.deleteByPrimaryKey(dId);
        if(deleteCount==1){
            return DeleteStateEnum.SUCCESS;
        }else {
            return DeleteStateEnum.FAILED;
        }
    }

    @Override
    public UpdateStateEnum update(Dish dish) {
        if(dish==null||dish.getName()==null||"".equals(dish.getName().trim())||
                dish.getPrice()==null||dish.getPrice()<0||dish.getCost()==null||dish.getCost()<0){
            return UpdateStateEnum.FAILED;
        }
        int updateCount=dishDao.updateByPrimaryKey(dish);
        if(updateCount==1){
            return UpdateStateEnum.SUCCESS;
        }else {
            return UpdateStateEnum.FAILED;
        }
    }

    @Override
    public List<SoldDishItem> getTop5SoldDishes(int rId) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        Date oneMonthAgo = calendar.getTime();
        List<SoldDishItem> soldDishItemList = dishDao.selectTop5SoldDishes(1,oneMonthAgo);
        for (Iterator<SoldDishItem> iterator = soldDishItemList.iterator();iterator.hasNext();){
            SoldDishItem soldDishItem = iterator.next();
            Dish dish =dishDao.selectById(soldDishItem.getdId());
            if (dish==null){
                iterator.remove();
                continue;
            }
            soldDishItem.setDishName(dish.getName());
        }
        return soldDishItemList;
    }
}
