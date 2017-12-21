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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/table")
public class TableController {

    @Autowired
    private DiningTableService tableService;

    @Autowired
    private TableGroupService tableGroupService;


    @RequestMapping(value = "/group/add",method = RequestMethod.POST)
    public String addTableGroup(TableGroup tableGroup, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");
        tableGroup.setrId(sessionRId);

        RegisterStateEnum registerState=tableGroupService.register(tableGroup);
        attributes.addFlashAttribute("rId",sessionRId);
        modelMap.addFlashAttribute("msg",registerState.getStateInfo());

        return "redirect:/restaurant/" +sessionRId+ "/admin/tablegroup";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addTable(DiningTable table, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");
        table.setGuestNumber(0);
        table.setServiceCode("0");
        table.setStatus(TableStateEnum.FREE.getStateInfo());

        RegisterStateEnum registerState=tableService.register(table);
        attributes.addFlashAttribute("rId",sessionRId);
        modelMap.addFlashAttribute("msg",registerState.getStateInfo());

        return "redirect:/restaurant/" +sessionRId+ "/admin/tablegroup";
    }

    @RequestMapping(value = "/{tId}/delete",method = RequestMethod.GET)
    public String deleteTable(@PathVariable("tId") int tId, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        DeleteStateEnum deleteState=null;
        if(sessionRId!=tableService.getRIdByTId(tId)){
            deleteState=DeleteStateEnum.FAILED;
        }else {
            deleteState=tableService.deleteById(tId);
        }
        attributes.addFlashAttribute("rId",sessionRId);
        modelMap.addFlashAttribute("msg",deleteState.getStateInfo());

        return "redirect:/restaurant/" +sessionRId+ "/admin/tablegroup";
    }

    @RequestMapping(value = "/group/{tgId}/delete",method = RequestMethod.GET)
    public String deleteTableGroup(@PathVariable("tgId") int tgId, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        DeleteStateEnum deleteState=null;
        if(sessionRId!=tableGroupService.getRIdByTgId(tgId)){
            deleteState=DeleteStateEnum.FAILED;
        }else {
            deleteState = tableGroupService.deleteByTgId(tgId);
        }
        attributes.addFlashAttribute("rId",sessionRId);
        modelMap.addFlashAttribute("msg",deleteState.getStateInfo());

        return "redirect:/restaurant/" +sessionRId+ "/admin/tablegroup";
    }

    @RequestMapping(value = "/group/{tgId}/update",method = RequestMethod.POST)
    public String updateTableGroup(TableGroup tableGroup, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        UpdateStateEnum updateState=null;
        if(sessionRId!=tableGroupService.getRIdByTgId(tableGroup.getTgId())){
            updateState=UpdateStateEnum.FAILED;
        }else {
            tableGroup.setrId(sessionRId);
            updateState=tableGroupService.update(tableGroup);
        }
        attributes.addFlashAttribute("rId",sessionRId);
        modelMap.addFlashAttribute("msg",updateState.getStateInfo());

        return "redirect:/restaurant/" +sessionRId+ "/admin/tablegroup";
    }

    @RequestMapping(value = "/{tId}/update",method = RequestMethod.POST)
    public String updateTable(DiningTable table, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        UpdateStateEnum updateState=null;
        if(sessionRId!=tableService.getRIdByTId(table.gettId())){
            updateState=UpdateStateEnum.FAILED;
        }else {
            updateState=tableService.updateSelective(table);
        }
        attributes.addFlashAttribute("rId",sessionRId);
        modelMap.addFlashAttribute("msg",updateState.getStateInfo());

        return "redirect:/restaurant/" +sessionRId+ "/admin/tablegroup";
    }

    @RequestMapping(value = "/{tId}/guest/update",method = RequestMethod.POST)
    public String updateGuestInfo(DiningTable table, HttpServletRequest request, RedirectAttributes attributes, RedirectAttributesModelMap modelMap){
        HttpSession session=request.getSession();
        int sessionRId=(int)session.getAttribute("rId");

        UpdateStateEnum updateState=null;
        if(sessionRId!=tableService.getRIdByTId(table.gettId())){
            updateState=UpdateStateEnum.FAILED;
        }else {
            updateState=tableService.updateGuestInfo(table);
        }
        attributes.addFlashAttribute("rId",sessionRId);
        modelMap.addFlashAttribute("msg",updateState.getStateInfo());

        int roleCode=(int)session.getAttribute("roleCode");
        if(roleCode== RoleEnum.ADMIN.getRoleCode()){
            return "redirect:/restaurant/" +sessionRId+ "/admin/tablegroup";
        }
        return "redirect:/restaurant/" +sessionRId+ "/tablegroup";
    }
}