package com.restaurant.web;

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

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private WaiterService waiterService;

    @Autowired
    private KitchenService kitchenService;

    @Autowired
    private CashierService cashierService;

    //登录入口
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login( Model model){
        return "login";
    }

    //管理员登录
    @RequestMapping(value = "/adminlogin",method = RequestMethod.POST)
    public String adminLogin(Restaurant rest, HttpServletRequest request, RedirectAttributes attributes, Model model){
        LoginStateEnum loginState=restaurantService.validate(rest);
        if(loginState!=LoginStateEnum.SUCCESS){
            model.addAttribute("msg", loginState.getStateInfo());
            model.addAttribute("rId",rest.getrId());
            return "login";
        }

        int rId=rest.getrId();
        HttpSession session=request.getSession();
        session.setAttribute("roleCode", RoleEnum.ADMIN.getRoleCode());
        session.setAttribute("rId",rId);

        model.addAttribute("rId",rId);
        attributes.addFlashAttribute("rId",rId);
        return "redirect:/restaurant/"+rId+"/admin";
    }

    //服务员登录
    @RequestMapping(value = "/waiterlogin",method = RequestMethod.POST)
    public String waiterLogin(Waiter waiter, HttpServletRequest request, RedirectAttributes attributes, Model model){

        LoginStateEnum loginState=waiterService.validate(waiter);
        if(loginState!=LoginStateEnum.SUCCESS){
            model.addAttribute("msg",loginState.getStateInfo());
            model.addAttribute("wId",waiter.getwId());
            return "login";
        }

        int rId=waiter.getrId();
        int wId=waiter.getwId();
        HttpSession session=request.getSession();
        session.setAttribute("roleCode", RoleEnum.WAITER.getRoleCode());
        session.setAttribute("wId",wId);
        session.setAttribute("rId",rId);

        model.addAttribute("rId",rId);
        attributes.addFlashAttribute("rId",rId);
        return "redirect:/restaurant/"+rId+"/tablegroup";
    }

    //厨房登录
    @RequestMapping(value = "/kitchenlogin",method = RequestMethod.POST)
    public String kitchenLogin(Kitchen kitchen, HttpServletRequest request, RedirectAttributes attributes, Model model){

        LoginStateEnum loginState=kitchenService.validate(kitchen);
        if(loginState!=LoginStateEnum.SUCCESS){
            model.addAttribute("msg",loginState.getStateInfo());
            model.addAttribute("kId",kitchen.getkId());
            return "login";
        }

        int rId=kitchen.getrId();
        int kId=kitchen.getkId();

        HttpSession session=request.getSession();
        session.setAttribute("roleCode", RoleEnum.KITCHEN.getRoleCode());
        session.setAttribute("rId",rId);
        session.setAttribute("kId",kId);

        model.addAttribute("rId",rId);
        attributes.addFlashAttribute("rId",rId);
        return "redirect:/kitchen/"+rId+"/task";
    }

    //收银台登录
    @RequestMapping(value = "/cashierlogin",method = RequestMethod.POST)
    public String cashierLogin(Cashier cashier, HttpServletRequest request, RedirectAttributes attributes, Model model){

        LoginStateEnum loginState=cashierService.validate(cashier);
        if(loginState!=LoginStateEnum.SUCCESS){
            model.addAttribute("msg",loginState.getStateInfo());
            model.addAttribute("cId",cashier.getcId());
            return "login";
        }

        int rId=cashier.getrId();
        int cId=cashier.getcId();

        HttpSession session=request.getSession();
        session.setAttribute("roleCode", RoleEnum.CASHIER.getRoleCode());
        session.setAttribute("rId",rId);
        session.setAttribute("cId",cId);

        model.addAttribute("rId",rId);
        attributes.addFlashAttribute("rId",rId);
        return "redirect:/cashier/"+rId+"/task";
    }

    //餐馆注册入口
    @RequestMapping(value = "/restreg",method = RequestMethod.GET)
    public String register( Model model){
        return "register";
    }

    //餐馆注册
    @RequestMapping(value = "/restaurant/add",
            method = RequestMethod.POST)
    public String restaurantRegister(Restaurant restaurant, Model model){
        RegisterStateEnum registerState=restaurantService.register(restaurant);
        if(registerState!=RegisterStateEnum.SUCCESS){
            model.addAttribute("msg", registerState.getStateInfo());
            model.addAttribute("restaurant",restaurant);
            return "register";
        }

        int rId=restaurant.getrId();
        cashierService.registerByRId(rId);

        model.addAttribute("msg",registerState.getStateInfo());
        model.addAttribute("rId",rId);
        return "login";
    }

    //服务员账号注册
    @RequestMapping(value = "/waiter/add",
            method = RequestMethod.POST)
    public String waiterRegister(Waiter waiter, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");
        waiter.setrId(sessionRId);
        waiter.setActive(new Byte("1"));
        RegisterStateEnum registerState=waiterService.register(waiter);

        modelMap.addFlashAttribute("msg",registerState.getStateInfo());
        attributes.addFlashAttribute("rId",sessionRId);

        return "redirect:/restaurant/"+sessionRId+"/admin/employee";
    }

    //厨房账号注册
    @RequestMapping(value = "/kitchen/add",
            method = RequestMethod.POST)
    public String kitchenRegister(Kitchen kitchen, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");
        kitchen.setActive(new Byte("1"));
        kitchen.setrId(sessionRId);
        RegisterStateEnum registerState=kitchenService.register(kitchen);

        modelMap.addFlashAttribute("msg",registerState.getStateInfo());
        attributes.addFlashAttribute("rId",sessionRId);

        return "redirect:/restaurant/"+sessionRId+"/admin/employee";
    }

    //服务员账号注册
    @RequestMapping(value = "/waiter/{wId}/delete",
            method = RequestMethod.GET)
    public String waiterDelete(@PathVariable("wId") int wId, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        DeleteStateEnum deleteState=null;

        if(sessionRId == waiterService.getRIdByWId(wId)){
            deleteState=waiterService.deleteById(wId);
        }else {
            deleteState=DeleteStateEnum.FAILED;
        }

        modelMap.addFlashAttribute("msg",deleteState.getStateInfo());
        attributes.addFlashAttribute("rId",sessionRId);
        return "redirect:/restaurant/"+sessionRId+"/admin/employee";
    }

    //删除厨房账号
    @RequestMapping(value = "/kitchen/{kId}/delete",
            method = RequestMethod.GET)
    public String kitchenDelete(@PathVariable("kId") int kId, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        DeleteStateEnum deleteState=null;

        if(sessionRId == kitchenService.getRIdByKId(kId)){
            deleteState=kitchenService.deleteById(kId);
        }else {
            deleteState=DeleteStateEnum.FAILED;
        }

        modelMap.addFlashAttribute("msg",deleteState.getStateInfo());
        attributes.addFlashAttribute("rId",sessionRId);
        return "redirect:/restaurant/"+sessionRId+"/admin/employee";
    }

    //服务员账号更新
    @RequestMapping(value = "/waiter/{wId}/update",
            method = RequestMethod.POST)
    public String waiterUpdate(Waiter waiter, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        UpdateStateEnum updateState=null;

        if(sessionRId == waiterService.getRIdByWId(waiter.getwId())){
            waiter.setrId(sessionRId);
            updateState=waiterService.update(waiter);
        }else {
            updateState=UpdateStateEnum.FAILED;
        }

        modelMap.addFlashAttribute("msg",updateState.getStateInfo());
        attributes.addFlashAttribute("rId",sessionRId);
        return "redirect:/restaurant/"+sessionRId+"/admin/employee";
    }

    //厨房账号更新
    @RequestMapping(value = "/kitchen/{kId}/update",
            method = RequestMethod.POST)
    public String kitchenUpdate(Kitchen kitchen, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        UpdateStateEnum updateState=null;

        if(sessionRId == kitchenService.getRIdByKId(kitchen.getkId())){
            kitchen.setrId(sessionRId);
            updateState=kitchenService.update(kitchen);
        }else {
            updateState=UpdateStateEnum.FAILED;
        }

        modelMap.addFlashAttribute("msg",updateState.getStateInfo());
        attributes.addFlashAttribute("rId",sessionRId);
        return "redirect:/restaurant/"+sessionRId+"/admin/employee";
    }

    //收银台账号更新
    @RequestMapping(value = "/cashier/{cId}/update",
            method = RequestMethod.POST)
    public String cashierUpdate(Cashier cashier, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        cashier.setrId(sessionRId);
        UpdateStateEnum updateState=null;

        if(cashier.getcId() == sessionRId){
            cashier.setrId(sessionRId);
            updateState=cashierService.update(cashier);
        }else {
            updateState=UpdateStateEnum.FAILED;
        }

        modelMap.addFlashAttribute("msg",updateState.getStateInfo());
        attributes.addFlashAttribute("rId",sessionRId);
        return "redirect:/restaurant/"+sessionRId+"/admin/employee";
    }
}