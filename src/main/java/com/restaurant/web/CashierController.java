package com.restaurant.web;

import com.restaurant.entity.*;
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
import java.util.List;

@Controller
@RequestMapping("/cashier")
public class CashierController {

    @Autowired
    private OrderFormService orderFormService;

    //收银台未结算的订单展示页面
    @RequestMapping(value = "/{rId}/task",
            method = RequestMethod.GET)
    public String task(@PathVariable int rId, HttpServletRequest request, Model model){
        int sessionRId=(int)request.getSession().getAttribute("rId");
        List<OrderForm>currentOrderFormList=orderFormService.selectNotEndByRId(sessionRId);
        model.addAttribute("currentOrderFormList",currentOrderFormList);
        return "cashier";
    }

    //结束订单
    @RequestMapping(value = "/{oId}/end",
            method = RequestMethod.POST)
    public String end(OrderForm orderForm, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){

        UpdateStateEnum updateState=orderFormService.end(orderForm);

        modelMap.addFlashAttribute("msg",updateState.getStateInfo());
        int sessionRId=(int)request.getSession().getAttribute("rId");
        attributes.addFlashAttribute("rId",sessionRId);
        return "redirect:/cashier/"+ sessionRId +"/task";
    }
}