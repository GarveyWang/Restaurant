package com.restaurant.web;

import com.restaurant.dao.TableGroupDao;
import com.restaurant.entity.*;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.RoleEnum;
import com.restaurant.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/restaurant")
@SessionAttributes({"restaurant"})
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private WaiterService waiterService;

    @Autowired
    private KitchenService kitchenService;

    @Autowired
    private CashierService cashierService;

    @Autowired
    private TableGroupService tableGroupService;

    @Autowired
    private DiningTableService diningTableService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login( Model model){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Restaurant restaurant, HttpServletRequest request, RedirectAttributes attributes, Model model){
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
        model.addAttribute("tableGroupList",tableGroupList);
        return "table";
    }


}