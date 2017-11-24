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

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class InsertTest {

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
    public void testRestaurantInsertSelective() throws Exception{
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        Restaurant restaurant=(Restaurant)context.getBean("restaurant");
        restaurant.setName("餐馆2");
        restaurant.setPassword("234");
        restaurantService.insertSelective(restaurant);
    }

    @Test
    public void testManagerInsertSelective() throws Exception{
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        Manager manager=(Manager)context.getBean("manager");
        manager.setName("经理3");
        manager.setPassword("234");
        manager.setPhone("12345678900");
        manager.setrId(2);
        managerService.insertSelective(manager);
    }

    @Test
    public void testCashierInsertSelective() throws Exception{
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        Cashier cashier=(Cashier)context.getBean("cashier");
        cashier.setPassword("1");
        cashier.setActive(new Byte("1"));
        cashier.setrId(1);
        cashierService.insertSelective(cashier);
    }

    @Test
    public void testKitchenInsertSelective() throws Exception{
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        Kitchen kitchen=(Kitchen)context.getBean("kitchen");
        kitchen.setActive(new Byte("1"));
        kitchen.setrId(1);
        kitchen.setName("Kitchen1");
        kitchen.setPassword("1");
        kitchenService.insertSelective(kitchen);
    }

    @Test
    public void testWaiterInsertSelective() throws Exception{
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        Waiter waiter=(Waiter)context.getBean("waiter");
        waiter.setName("服务员1");
        waiter.setActive(new Byte("1"));
        waiter.setPassword("123");
        waiter.setrId(1);
        waiterService.insertSelective(waiter);
    }

    @Test
    public void testTableGroupInsertSelective() throws Exception{
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        TableGroup tableGroup=(TableGroup)context.getBean("tableGroup");
        tableGroup.setName("Group1");
        tableGroup.setrId(1);
        tableGroupService.insertSelective(tableGroup);
    }

    @Test
    public void testDiningTableInsertSelective() throws Exception{
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        DiningTable diningTable=(DiningTable)context.getBean("diningTable");
        diningTable.setCapacity(4);
        diningTable.setDescription("第一张桌子");
        diningTable.setgId(1);
        diningTable.setGuestNumber(3);
        diningTable.setName("桌子1");
        diningTable.setServiceCode("1");
        diningTable.setStatus("已占用");
        diningTableService.insertSelective(diningTable);
    }

    @Test
    public void testOrderInsertSelective() throws Exception{
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        OrderForm order=(OrderForm)context.getBean("orderForm");
        order.setSubmitTime(new Date());
        order.setDiscount(1.0f);
        order.setStatus("已提交");
        order.setTotalPrice(0);
        order.settId(1);
        orderService.insertSelective(order);
    }

    @Test
    public void testDishInsertSelective()throws Exception{
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        Dish dish=(Dish)context.getBean("dish");
        dish.setName("驴打滚");
        dish.setDescription("驴打滚打滚");
        dish.setPrice(20);
        dish.setCost(10);
        dish.setActive(new Byte("0"));
        dish.setStatus("售罄");
        dishService.insertSelective(dish);
    }

    @Test
    public void testOrderDishInsert()throws Exception{
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        OrderDish orderDish=(OrderDish)context.getBean("orderDish");
        orderDish.setoId(1);
        orderDish.setdId(1);
        orderDish.setDescription("少放辣椒");
        orderDish.setStatus("正在烹饪");
        orderDishService.insert(orderDish);
    }

}
