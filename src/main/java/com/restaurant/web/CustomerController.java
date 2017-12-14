package com.restaurant.web;

import com.restaurant.dto.OrderFormItem;
import com.restaurant.entity.*;
import com.restaurant.enums.*;
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
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private TableGroupService tableGroupService;

    @Autowired
    private DiningTableService diningTableService;

    @Autowired
    private DishGroupService dishGroupService;

    @Autowired
    private OrderDishService orderDishService;

    @Autowired
    private OrderFormService orderFormService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(DiningTable diningtable, HttpServletRequest request, RedirectAttributes attributes, Model model){

        LoginStateEnum loginState=diningTableService.validate(diningtable);
        if(loginState!=LoginStateEnum.SUCCESS){
            model.addAttribute("msg", loginState.getStateInfo());
            model.addAttribute("tId",diningtable.gettId());
            model.addAttribute("serviceCode",diningtable.getServiceCode());
            return "welcome";
        }

        int tId=diningtable.gettId();
        TableGroup tableGroup=tableGroupService.selectById(diningtable.getTgId());

        HttpSession session=request.getSession();
        session.setAttribute("roleCode", RoleEnum.CUSTOMER.getRoleCode());
        session.setAttribute("rId",tableGroup.getrId());
        session.setAttribute("tId",tId);
        session.setAttribute("serviceCode",diningtable.getServiceCode());

        attributes.addFlashAttribute("tId",tId);
        return "redirect:/customer/"+tId+"/menu";
    }

    @RequestMapping(value = "/{tId}/menu",
            method = RequestMethod.GET)
    public String menu(@PathVariable("tId") int tId, HttpServletRequest request, Model model){
        HttpSession session=request.getSession();

        int sessionRId=(int)session.getAttribute("rId");
        List<DishGroup> dishGroupList=dishGroupService.selectByRId(sessionRId);
        model.addAttribute("dishGroupList",dishGroupList);

        int sessionTId=(int)session.getAttribute("tId");
        OrderForm currentOrderForm=orderFormService.selectNotEndByTId(sessionTId);
        if(currentOrderForm==null){
            orderFormService.register(sessionRId,sessionTId);
            currentOrderForm=orderFormService.selectNotEndByTId(sessionTId);

        }

        int totalPrice = orderFormService.getTotalPrice(currentOrderForm.getoId());
        int oId=currentOrderForm.getoId();
        List<OrderFormItem> orderFormItemList=orderDishService.selectOrderFormItemByOId(oId);

        session.setAttribute("oId",oId);

        model.addAttribute("orderFormItemList",orderFormItemList);
        model.addAttribute("oId",oId);
        model.addAttribute("tId",sessionTId);
        model.addAttribute("totalPrice",totalPrice);
        return "menu";
    }

    @RequestMapping(value = "orderdish/{dId}/add",
            method = RequestMethod.POST)
    public String addOrderDish(OrderDish orderDish,HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();

        int sessionOId=(int)session.getAttribute("oId");
        orderDish.setoId(sessionOId);

        RegisterStateEnum registerStateEnum=orderDishService.register(orderDish);
        orderFormService.countTotalPrice(sessionOId);

        int sessionTId=(int)session.getAttribute("tId");
        attributes.addFlashAttribute("tId",sessionTId);

        modelMap.addFlashAttribute("msg",registerStateEnum.getStateInfo());
        return "redirect:/customer/"+sessionTId+"/menu";
    }

    @RequestMapping(value = "orderdish/{dId}/delete",method = RequestMethod.GET)
    public String deleteOrderDish(@PathVariable("dId") int dId, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionTId=(int)session.getAttribute("tId");
        int sessionOId=(int)session.getAttribute("oId");

        DeleteStateEnum deleteState=orderDishService.deleteByPrimaryKey(sessionOId,dId);
        orderFormService.countTotalPrice(sessionOId);

        attributes.addFlashAttribute("tId",sessionTId);
        modelMap.addFlashAttribute("msg",deleteState.getStateInfo());

        return "redirect:/customer/" +sessionTId+ "/menu";
    }

    @RequestMapping(value = "orderdish/{dId}/update",
            method = RequestMethod.POST)
    public String updateOrderDish(OrderDish orderDish,HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();

        int sessionOId=(int)session.getAttribute("oId");
        orderDish.setoId(sessionOId);

        UpdateStateEnum registerStateEnum=orderDishService.update(orderDish);
        orderFormService.countTotalPrice(sessionOId);

        int sessionTId=(int)session.getAttribute("tId");
        attributes.addFlashAttribute("tId",sessionTId);

        modelMap.addFlashAttribute("msg",registerStateEnum.getStateInfo());
        return "redirect:/customer/"+sessionTId+"/menu";
    }
}