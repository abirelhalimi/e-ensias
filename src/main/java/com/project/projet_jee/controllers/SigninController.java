package com.project.projet_jee.controllers;

import com.project.projet_jee.models.Account;
import com.project.projet_jee.services.ServiceRobot;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SigninController {

    @Autowired
    private ServiceRobot serviceRobot;


    @GetMapping(value = {"/SignIn"})
    public String signin() {

        return "signin";
    }
    @PostMapping(value = {"/SignIn"})
    public String loginPost(@RequestParam String fname, String lname, String email, String pass1, String pass2, Model model,HttpSession session) {
        Account account=serviceRobot.checkEmail(email);
        if(account!=null){

            model.addAttribute("message1","Email already exist");
            return "signin";
        }
        else {
            if(pass1.equals(pass2)){
                account=serviceRobot.createAccount(fname+" "+lname, email, pass1);
                return "redirect:/login";
            }
            else{
                model.addAttribute("message2", "Passwords don't match");
                return "signin";
            }

        }
    }


}
