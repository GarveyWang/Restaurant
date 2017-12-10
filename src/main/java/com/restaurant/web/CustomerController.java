package com.restaurant.web;

import com.restaurant.dto.OrderFormItem;
import com.restaurant.entity.*;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RoleEnum;
import com.restaurant.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private TableGroupService tableGroupService;

    @Autowired
    private DiningTableService diningTableService;

    @Autowired
    private DishGroupService dishGroupService;

    @Autowired
    private DishService dishService;

    @Autowired
    private OrderDishService orderDishService;

    @Autowired
    private OrderFormService orderFormService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(DiningTable diningtable, HttpServletRequest request, RedirectAttributes attributes, Model model){

        //如果登录信息不完整，返回并提示
        if(diningtable==null||diningtable.gettId()==null||"".equals(diningtable.gettId())
                ||diningtable.getServiceCode()==null||"".equals(diningtable.getServiceCode())){
            model.addAttribute("msg",LoginStateEnum.IMCOMPLETE.getStateInfo());
            model.addAttribute("tId",diningtable.gettId());
            model.addAttribute("serviceCode",diningtable.getServiceCode());
            return "welcome";
        }

        int tId=diningtable.gettId();
        String serviceCode=diningtable.getServiceCode();

        //比对数据库，如果账号不存在或者密码错误，返回并提示
        DiningTable tableFromDB=diningTableService.selectById(tId);
        if(tableFromDB==null||
                !tableFromDB.getServiceCode().equals(serviceCode)){
            model.addAttribute("msg", LoginStateEnum.INFO_ERROR.getStateInfo());
            model.addAttribute("tId",tId);
            model.addAttribute("serviceCode",serviceCode);
            return "welcome";
        }

        TableGroup tableGroup=tableGroupService.selectById(tableFromDB.getTgId());

        HttpSession session=request.getSession();
        session.setAttribute("roleCode", RoleEnum.CUSTOMER.getRoleCode());
        session.setAttribute("rId",tableGroup.getrId());
        session.setAttribute("tId",tId);
        session.setAttribute("serviceCode",serviceCode);


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
        if(currentOrderForm!=null){
            int oId=currentOrderForm.getoId();
            List<OrderDish> orderDishList=orderDishService.selectByOId(oId);
            List<OrderFormItem> orderFormItemList=new ArrayList<OrderFormItem>();
            for(OrderDish orderDish:orderDishList){
                int d_id=orderDish.getdId();
                Dish dish=dishService.selectById(d_id);
                String dishName=dish.getName();
                int price=dish.getPrice();
                OrderFormItem orderFormItem=new OrderFormItem(d_id,orderDish.getNumber(),orderDish.getRemark(),orderDish.getStatus(),orderDish.getOrderTime());
                orderFormItem.setName(dishName);
                orderFormItem.setPrice(price);
                orderFormItemList.add(orderFormItem);
            }
            model.addAttribute("hasOrdered",true);
            model.addAttribute("orderFormItemList",orderFormItemList);
            model.addAttribute("oId",oId);
        }else{
            model.addAttribute("hasOrdered",false);
        }

        return "menu";
    }
}