package com.restaurant.web;

import com.restaurant.entity.*;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.RoleEnum;
import com.restaurant.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login( Model model){
        return "login";
    }

    @RequestMapping(value = "/adminlogin",method = RequestMethod.POST)
    public String adminLogin(Restaurant restaurant, HttpServletRequest request, RedirectAttributes attributes, Model model){
        //如果登录信息不完整，返回并提示
        if(restaurant==null||restaurant.getrId()==null||"".equals(restaurant.getrId())
                ||restaurant.getPassword()==null||"".equals(restaurant.getPassword())){
            model.addAttribute("msg",LoginStateEnum.IMCOMPLETE.getStateInfo());
            model.addAttribute("rId",restaurant.getrId());
            return "login";
        }

        //比对数据库，如果账号不存在或者密码错误，返回并提示
        Restaurant restaurantFromDB=restaurantService.selectRestaurantById(restaurant.getrId());
        if(restaurantFromDB==null||
                !restaurantFromDB.getPassword().equals(restaurant.getPassword())){
            model.addAttribute("msg", LoginStateEnum.INFO_ERROR.getStateInfo());
            model.addAttribute("rId",restaurant.getrId());
            return "login";
        }

        int rId=restaurant.getrId();
        HttpSession session=request.getSession();
        session.setAttribute("roleCode", RoleEnum.ADMIN.getRoleCode());
        session.setAttribute("rId",rId);

        model.addAttribute("rId",rId);
        attributes.addFlashAttribute("rId",rId);
        return "redirect:/restaurant/"+rId+"/admin";
    }

    @RequestMapping(value = "/waiterlogin",method = RequestMethod.POST)
    public String waiterLogin(Waiter waiter, HttpServletRequest request, RedirectAttributes attributes, Model model){

        //如果登录信息不完整，返回并提示
        if(waiter==null||waiter.getwId()==null||"".equals(waiter.getwId())
                ||waiter.getPassword()==null||"".equals(waiter.getPassword())){
            model.addAttribute("msg",LoginStateEnum.IMCOMPLETE.getStateInfo());
            model.addAttribute("wId",waiter.getwId());
            return "login";
        }

        //比对数据库，如果账号不存在或者密码错误，返回并提示
        Waiter waiterFromDB=waiterService.selectById(waiter.getwId());
        if(waiterFromDB==null||
                !waiterFromDB.getPassword().equals(waiter.getPassword())){
            model.addAttribute("msg", LoginStateEnum.INFO_ERROR.getStateInfo());
            model.addAttribute("wId",waiter.getwId());
            return "login";
        }

        int rId=waiterFromDB.getrId();
        int wId=waiter.getwId();
        HttpSession session=request.getSession();
        session.setAttribute("roleCode", RoleEnum.WAITER.getRoleCode());
        session.setAttribute("rId",rId);
        session.setAttribute("wId",wId);

        model.addAttribute("rId",rId);
        attributes.addFlashAttribute("rId",rId);
        return "redirect:/restaurant/"+rId+"/tablegroup";
    }

    @RequestMapping(value = "/kitchenlogin",method = RequestMethod.POST)
    public String kitchenLogin(Kitchen kitchen, HttpServletRequest request, RedirectAttributes attributes, Model model){

        //如果登录信息不完整，返回并提示
        if(kitchen==null||kitchen.getkId()==null||"".equals(kitchen.getkId())
                ||kitchen.getPassword()==null||"".equals(kitchen.getPassword())){
            model.addAttribute("msg",LoginStateEnum.IMCOMPLETE.getStateInfo());
            model.addAttribute("kId",kitchen.getkId());
            return "login";
        }

        //比对数据库，如果账号不存在或者密码错误，返回并提示
        Kitchen kitchenFromDB=kitchenService.selectById(kitchen.getkId());
        if(kitchenFromDB==null||
                !kitchenFromDB.getPassword().equals(kitchen.getPassword())){
            model.addAttribute("msg", LoginStateEnum.INFO_ERROR.getStateInfo());
            model.addAttribute("kId",kitchen.getkId());
            return "login";
        }

        int rId=kitchenFromDB.getrId();
        int kId=kitchen.getkId();
        HttpSession session=request.getSession();
        session.setAttribute("roleCode", RoleEnum.KITCHEN.getRoleCode());
        session.setAttribute("rId",rId);
        session.setAttribute("kId",kId);

        model.addAttribute("rId",rId);
        attributes.addFlashAttribute("rId",rId);
        return "redirect:/kitchen/"+rId+"/task";
    }

    @RequestMapping(value = "/cashierlogin",method = RequestMethod.POST)
    public String CashierLogin(Cashier cashier, HttpServletRequest request, RedirectAttributes attributes, Model model){

        //如果登录信息不完整，返回并提示
        if(cashier==null||cashier.getcId()==null||"".equals(cashier.getcId())
                ||cashier.getPassword()==null||"".equals(cashier.getPassword())){
            model.addAttribute("msg",LoginStateEnum.IMCOMPLETE.getStateInfo());
            model.addAttribute("cId",cashier.getcId());
            return "login";
        }

        //比对数据库，如果账号不存在或者密码错误，返回并提示
        Cashier cashierFromDB=cashierService.selectById(cashier.getcId());
        if(cashierFromDB==null||
                !cashierFromDB.getPassword().equals(cashier.getPassword())){
            model.addAttribute("msg", LoginStateEnum.INFO_ERROR.getStateInfo());
            model.addAttribute("cId",cashier.getcId());
            return "login";
        }

        int rId=cashierFromDB.getrId();
        int cId=cashier.getcId();
        HttpSession session=request.getSession();
        session.setAttribute("roleCode", RoleEnum.CASHIER.getRoleCode());
        session.setAttribute("rId",rId);
        session.setAttribute("cId",cId);

        model.addAttribute("rId",rId);
        attributes.addFlashAttribute("rId",rId);
        return "redirect:/cashier/"+rId+"/task";
    }


    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register( Model model){
        return "register";
    }

    @RequestMapping(value = "/register",
            method = RequestMethod.POST)
    public String register(Restaurant restaurant, Model model){
        //如果有账号信息缺失，提示账号信息不完整
        if(restaurant==null||restaurant.getName()==null||"".equals(restaurant.getName())
                ||restaurant.getrId()==null||"".equals(restaurant.getrId())
                ||restaurant.getPassword()==null||"".equals(restaurant.getPassword())){
            model.addAttribute("msg", RegisterStateEnum.IMCOMPLETE.getStateInfo());
            model.addAttribute("restaurant",restaurant);
            return "register";
        }

        int insertCount=restaurantService.insert(restaurant);
        //如果插入条数为0，说明主键冲突，该账号已经存在
        //如果插入条数为1，说明插入成功，跳转登录界面
        if(insertCount<1){
            model.addAttribute("msg",RegisterStateEnum.ID_REPEAT.getStateInfo());
            model.addAttribute("restaurant",restaurant);
            return "register";
        }else{
            model.addAttribute("msg",RegisterStateEnum.SUCCESS.getStateInfo());
            model.addAttribute("rId",restaurant.getrId());
            return "login";
        }
    }


}