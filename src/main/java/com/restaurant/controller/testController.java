package com.restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class testController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
