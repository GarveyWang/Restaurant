package com.restaurant.dao;

import com.restaurant.entity.Kitchen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class KitchenDaoTest {

    @Resource
    private KitchenDao kitchenDao;

    @Test
    public void selectByRId() throws Exception {
        int rId=1;
        List<Kitchen> kitchenList=kitchenDao.selectByRId(rId);
        for(Kitchen kitchen:kitchenList){
            System.out.println(kitchen.toString());
        }
    }

}