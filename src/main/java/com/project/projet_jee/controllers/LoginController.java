package com.project.projet_jee.controllers;

import com.project.projet_jee.models.Account;
import com.project.projet_jee.services.ServiceRobot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private ServiceRobot serviceRobot;

    @GetMapping(value = {"/login"})
    public String login() {
        return "login";
    }


    @PostMapping(value = {"/login"})
    public String loginPost(@RequestParam String email, String pass, HttpSession session, Model model) {


        if(serviceRobot.checkLogin(email,pass)){
            Account account=serviceRobot.checkEmail(email);
            session.setAttribute("user",account);
            model.addAttribute("user",account);
            return "redirect:/dashboard";
        }
        else {
            model.addAttribute("message", "Email or Password invalid, please verify");
            return "login";
        }
    }
}
