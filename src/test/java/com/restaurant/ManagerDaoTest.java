package com.restaurant;

import com.restaurant.model.Restaurant;
import com.restaurant.service.impl.ManagerService;
import com.restaurant.service.impl.RestaurantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ManagerDaoTest {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private RestaurantService restaurantService;

    @Test
    public void testSelectManager() throws Exception{
        int id=1;
        Restaurant restaurant=restaurantService.selectRestaurant(id);
        System.out.println(restaurant);
    }
}
