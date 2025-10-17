package com.docubyte.test.app02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String welcomePage(){
        return "welcomepage";
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(){
        return "adminpage";
    }


    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String employeePage(){
        return "emppage";
    }


    @RequestMapping(value = "/std", method = RequestMethod.GET)
    public String studentPage(){
        return "stdpage";
    }
}

