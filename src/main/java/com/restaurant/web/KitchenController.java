package com.restaurant.web;

import com.restaurant.dto.KitchenTaskItem;
import com.restaurant.entity.DishGroup;
import com.restaurant.entity.OrderDish;
import com.restaurant.enums.UpdateStateEnum;
import com.restaurant.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/kitchen")
public class KitchenController {
    @Autowired
    private KitchenService kitchenService;

    @Autowired
    private OrderDishService orderDishService;

    @Autowired
    private DishGroupService dishGroupService;

    //展示厨房任务
    @RequestMapping(value = "/{rId}/task",
            method = RequestMethod.GET)
    public String task(@PathVariable int rId, HttpServletRequest request, Model model){
        int sessionRId=(int)request.getSession().getAttribute("rId");
        List<KitchenTaskItem> kitchenTaskItemList=kitchenService.selectTaskByRId(sessionRId);
        model.addAttribute("kitchenTaskItemList",kitchenTaskItemList);
        return "kitchen";
    }

    //烹饪某样点单
    @RequestMapping(value = "{oId}/{dId}/cook",
            method = RequestMethod.POST)
    public String cook(OrderDish orderDish, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        UpdateStateEnum updateState=orderDishService.cook(orderDish);

        HttpSession session=request.getSession();
        int sessionrId=(int)session.getAttribute("rId");
        attributes.addFlashAttribute("tId",sessionrId);

        modelMap.addFlashAttribute("msg",updateState.getStateInfo());
        return "redirect:/kitchen/"+sessionrId+"/task";
    }

    //将某样烹饪完的菜品上菜
    @RequestMapping(value = "{oId}/{dId}/serve",
            method = RequestMethod.POST)
    public String serve(OrderDish orderDish, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        UpdateStateEnum updateState=orderDishService.serve(orderDish);

        HttpSession session=request.getSession();
        int sessionrId=(int)session.getAttribute("rId");
        attributes.addFlashAttribute("tId",sessionrId);

        modelMap.addFlashAttribute("msg",updateState.getStateInfo());
        return "redirect:/kitchen/"+sessionrId+"/task";
    }

    //菜品管理页面
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