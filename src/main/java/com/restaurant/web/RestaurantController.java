package com.restaurant.web;

import com.restaurant.entity.*;
import com.restaurant.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/restaurant")
@SessionAttributes({"restaurant"})
public class RestaurantController {

    @Autowired
    private WaiterService waiterService;

    @Autowired
    private KitchenService kitchenService;

    @Autowired
    private CashierService cashierService;

    @Autowired
    private TableGroupService tableGroupService;


    @Autowired
    private DishGroupService dishGroupService;


    @RequestMapping(value = "/{rId}/admin",
            method = RequestMethod.GET)
    public String admin(@PathVariable int rId, Model model){
        return "admin";
    }

    @RequestMapping(value = "/{rId}/employee",method = RequestMethod.GET)
    public String employee(@PathVariable int rId, HttpServletRequest request, Model model){
        int sessionRId=(int)request.getSession().getAttribute("rId");

        List<Waiter>waiterList=waiterService.selectByRId(sessionRId);
        model.addAttribute("waiterList",waiterList);

        List<Kitchen>kitchenList=kitchenService.selectByRId(sessionRId);
        model.addAttribute("kitchenList",kitchenList);

        Cashier cashier=cashierService.selectByRId(sessionRId);
        model.addAttribute("cashier",cashier);

        return "employee";
    }

    @RequestMapping(value = "/{rId}/tablegroup",method = RequestMethod.GET)
    public String tableGroup(@PathVariable int rId, HttpServletRequest request, Model model){
        int sessionRId=(int)request.getSession().getAttribute("rId");
        List<TableGroup>tableGroupList=tableGroupService.selectByRId(sessionRId);

        int tableCount=tableGroupService.getTableCount(tableGroupList);
        model.addAttribute("tableGroupList",tableGroupList);
        model.addAttribute("tableCount",tableCount);
        return "table";
    }

    @RequestMapping(value = "/{rId}/dishgroup",method = RequestMethod.GET)
    public String dishGroup(@PathVariable int rId, HttpServletRequest request, Model model){
        int sessionRId=(int)request.getSession().getAttribute("rId");
        List<DishGroup>dishGroupList=dishGroupService.selectByRId(sessionRId);

        int dishCount=dishGroupService.getDishCount(dishGroupList);
        model.addAttribute("dishGroupList",dishGroupList);
        model.addAttribute("dishCount",dishCount);
        return "dish";
    }

}