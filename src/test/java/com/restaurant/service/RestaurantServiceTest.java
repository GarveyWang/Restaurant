package com.restaurant.service;

import com.restaurant.entity.Restaurant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class RestaurantServiceTest {
    @Resource
    private RestaurantService restaurantService;

    @Test
    public void insert() throws Exception {
        Restaurant restaurant=new Restaurant();
        restaurant.setrId(1001);
        restaurant.setPassword("1001");
        restaurant.setName("1001");
        restaurantService.insert(restaurant);
    }

    @Test
    public void selectRestaurantById() throws Exception {
        int id=1;
        Restaurant restaurant=restaurantService.selectRestaurantById(id);
        System.out.println(restaurant.getName());
    }

    @Test
    public void isRestaurantExists() throws Exception{
        int id=1000;
        boolean isExists=restaurantService.isRestaurantExists(id);
        System.out.println(isExists);
    }

    @Test
    public void selectRestaurantByIdWithEmployee() throws Exception {
        int id=1;
        Restaurant restaurant=restaurantService.selectRestaurantByIdWithEmployee(id);
        System.out.println(restaurant.getKitchens().get(0).getName());
    }
}