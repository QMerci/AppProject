package com.leadlink.CRM.controller;

import com.leadlink.CRM.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.leadlink.CRM.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model){
        model.addAttribute("user", new UserModel());
        return "registrationPage";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute UserModel user){
        userService.register(user);
        return "redirect:/login?success";
    }

}
