package com.restaurant.service;

import com.restaurant.model.*;
import com.restaurant.service.impl.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class selectTest {

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private KitchenService kitchenService;
    @Autowired
    private CashierService cashierService;
    @Autowired
    private WaiterService waiterService;
    @Autowired
    private TableGroupService tableGroupService;
    @Autowired
    private DiningTableService diningTableService;
    @Autowired
    private OrderFormService orderService;
    @Autowired
    private DishService dishService;
    @Autowired
    private OrderDishService orderDishService;


    @Test
    public void test() throws Exception{
    }

}
