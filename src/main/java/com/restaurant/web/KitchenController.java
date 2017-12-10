package com.restaurant.web;

import com.restaurant.dao.OrderFormDao;
import com.restaurant.dto.KitchenTaskItem;
import com.restaurant.entity.*;
import com.restaurant.service.*;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    private TableGroupService tableGroupService;

    @Autowired
    private DiningTableService diningTableService;

    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private OrderDishService orderDishService;

    @Autowired
    private DishService dishService;

    @RequestMapping(value = "/{rId}/task",
            method = RequestMethod.GET)
    public String task(@PathVariable int rId, HttpServletRequest request, Model model){

        int sessionRId=(int)request.getSession().getAttribute("rId");

        List<KitchenTaskItem> kitchenTaskItemList=new ArrayList<KitchenTaskItem>();

        List<OrderForm> OrderFormList=orderFormService.selectNotEndByRId(sessionRId);
        for(OrderForm orderForm:OrderFormList){
            int oId=orderForm.getoId();
            int tId=orderForm.gettId();
            DiningTable table=diningTableService.selectById(tId);
            String tableName=table.getName();
            TableGroup tableGroup=tableGroupService.selectById(table.getTgId());
            String tableGroupName=tableGroup.getName();
            List<OrderDish> orderDishList=orderDishService.selectNotEndByOId(oId);
            for(OrderDish orderDish:orderDishList){
                int dId=orderDish.getdId();
                KitchenTaskItem item=new KitchenTaskItem(dId,orderDish.getNumber(),orderDish.getRemark(),orderDish.getOrderTime(),orderDish.getStatus());
                Dish dish=dishService.selectById(dId);
                item.setDishName(dish.getName());
                item.setTableName(tableName);
                item.setTableGroupName(tableGroupName);
                kitchenTaskItemList.add(item);
            }
        }

        model.addAttribute("kitchenTaskItemList",kitchenTaskItemList);

        return "kitchen";
    }
}