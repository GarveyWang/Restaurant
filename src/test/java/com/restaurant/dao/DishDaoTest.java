package com.restaurant.dao;

import com.restaurant.dto.SoldDishItem;
import com.restaurant.entity.Dish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class DishDaoTest {

    @Resource
    private DishDao dishDao;

    @Test
    public void selectByDgId() throws Exception {
        int dgId=1;
        List<Dish> dishes=dishDao.selectByDgId(dgId);
        for(Dish dish: dishes){
            System.out.println(dish.getName());
        }
    }

    @Test
    public void selectTop5SoldDishes() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        Date oneMonthAgo = calendar.getTime();
        List<SoldDishItem> soldDishItemList = dishDao.selectTop5SoldDishes(1,oneMonthAgo);
        System.out.println(soldDishItemList.size());
    }

}