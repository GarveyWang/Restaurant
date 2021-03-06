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


    //管理员界面
    @RequestMapping(value = "/{rId}/admin",
            method = RequestMethod.GET)
    public String admin(@PathVariable int rId, Model model){
        return "admin";
    }

    //管理员工界面
    @RequestMapping(value = "/{rId}/admin/employee",method = RequestMethod.GET)
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

    //餐桌管理（管理员）
    @RequestMapping(value = "/{rId}/admin/tablegroup",method = RequestMethod.GET)
    public String tableGroupForAdmin(@PathVariable int rId, HttpServletRequest request, Model model){
        int sessionRId=(int)request.getSession().getAttribute("rId");
        List<TableGroup>tableGroupList=tableGroupService.selectByRId(sessionRId);

        int tableCount=tableGroupService.getTableCount(tableGroupList);
        model.addAttribute("role","admin");
        model.addAttribute("tableGroupList",tableGroupList);
        model.addAttribute("tableCount",tableCount);
        return "table";
    }

    //餐桌管理（服务员）
    @RequestMapping(value = "/{rId}/tablegroup",method = RequestMethod.GET)
    public String tableGroupForWaiter(@PathVariable int rId, HttpServletRequest request, Model model){
        int sessionRId=(int)request.getSession().getAttribute("rId");
        List<TableGroup>tableGroupList=tableGroupService.selectByRId(sessionRId);
        int tableCount=tableGroupService.getTableCount(tableGroupList);
        model.addAttribute("role","waiter");
        model.addAttribute("tableGroupList",tableGroupList);
        model.addAttribute("tableCount",tableCount);
        return "table";
    }

}