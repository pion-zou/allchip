package com.electronic.allchip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }

    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg","Hello,Thymeleaf");
        //classpath:/templates/test.html
        return "test";
    }

    @RequestMapping("/t2")
    public String test2(Map<String, Object> map){
        map.put("msg" , "<h1>Hello</h1>");
        map.put("users" , Arrays.asList("a" , "b" ,"c"));
        return "test";
    }

    @RequestMapping(path = {"/" , "/index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping(path = {"/{page}.html"})
    public String toPage(@PathVariable String page){
        return page;
    }



}