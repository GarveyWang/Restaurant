package com.restaurant.dao;

import com.restaurant.entity.Dish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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

}