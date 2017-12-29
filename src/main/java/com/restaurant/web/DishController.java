package com.restaurant.web;


import com.restaurant.entity.Dish;
import com.restaurant.entity.DishGroup;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;
import com.restaurant.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private DishGroupService dishGroupService;

    //增加菜品组
    @RequestMapping(value = "/group/add",method = RequestMethod.POST)
    public String addDishGroup(DishGroup dishGroup, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        dishGroup.setrId(sessionRId);
        RegisterStateEnum registerState = dishGroupService.register(dishGroup);

        attributes.addFlashAttribute("rId",sessionRId);
        modelMap.addFlashAttribute("msg",registerState.getStateInfo());

        return "redirect:/kitchen/" +sessionRId+ "/dishgroup";
    }

    //增加菜品
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addDish(Dish dish, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        RegisterStateEnum registerState=dishService.register(dish);
        attributes.addFlashAttribute("rId",sessionRId);
        modelMap.addFlashAttribute("msg",registerState.getStateInfo());

        return "redirect:/kitchen/" +sessionRId+ "/dishgroup";
    }

    //删除菜品组
    @RequestMapping(value = "/group/{dgId}/delete",method = RequestMethod.GET)
    public String deleteDishGroup(@PathVariable("dgId") int dgId, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        DeleteStateEnum deleteState = null;
        if(sessionRId != dishGroupService.getRIdByDgId(dgId)){
            deleteState = DeleteStateEnum.FAILED;
        }else {
            deleteState = dishGroupService.deleteByDgId(dgId);
        }
        attributes.addFlashAttribute("rId",sessionRId);
        modelMap.addFlashAttribute("msg",deleteState.getStateInfo());

        return "redirect:/kitchen/" +sessionRId+ "/dishgroup";
    }

    //删除菜品
    @RequestMapping(value = "/{dId}/delete",method = RequestMethod.GET)
    public String deleteDish(@PathVariable("dId") int dId, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        DeleteStateEnum deleteState=null;
        if(sessionRId!=dishService.getRIdByDId(dId)){
            deleteState=DeleteStateEnum.FAILED;
        }else {
            deleteState=dishService.deleteById(dId);
        }
        attributes.addFlashAttribute("rId",sessionRId);
        modelMap.addFlashAttribute("msg",deleteState.getStateInfo());

        return "redirect:/kitchen/" +sessionRId+ "/dishgroup";
    }

    //更新菜品组
    @RequestMapping(value = "/group/{dgId}/update",method = RequestMethod.POST)
    public String updateDishGroup(DishGroup dishGroup, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        UpdateStateEnum updateState=null;
        if(sessionRId!=dishGroupService.getRIdByDgId(dishGroup.getDgId())){
            updateState=UpdateStateEnum.FAILED;
        }else {
            dishGroup.setrId(sessionRId);
            updateState=dishGroupService.update(dishGroup);
        }
        attributes.addFlashAttribute("rId",sessionRId);
        modelMap.addFlashAttribute("msg",updateState.getStateInfo());

        return "redirect:/kitchen/" +sessionRId+ "/dishgroup";
    }

    //更新菜品
    @RequestMapping(value = "/{dId}/update",method = RequestMethod.POST)
    public String updateDish(Dish dish, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        UpdateStateEnum updateState=null;
        if(sessionRId!=dishService.getRIdByDId(dish.getdId())){
            updateState=UpdateStateEnum.FAILED;
        }else {
            updateState=dishService.update(dish);
        }
        attributes.addFlashAttribute("rId",sessionRId);
        modelMap.addFlashAttribute("msg",updateState.getStateInfo());

        return "redirect:/restaurant/" +sessionRId+ "/dishgroup";
    }

}