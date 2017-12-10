package com.restaurant.web;

import com.restaurant.dto.KitchenTaskItem;
import com.restaurant.entity.*;
import com.restaurant.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cashier")
public class CashierController {

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
        List<OrderForm>currentOrderFormList=orderFormService.selectNotEndByRId(sessionRId);
        model.addAttribute("currentOrderFormList",currentOrderFormList);
        return "cashier";
    }
}