package com.leadlink.CRM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHome(){
        return "home";
    }

    @GetMapping("/dash")
    public String getDash(Model model){
        model.addAttribute("pageName", "Nástěnka");
        return "dash";
    }
}
