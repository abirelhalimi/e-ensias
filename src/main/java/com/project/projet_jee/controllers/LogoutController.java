package com.project.projet_jee.controllers;

import com.project.projet_jee.services.ServiceRobot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @Autowired
    private ServiceRobot serviceRobot;


    @GetMapping(value = {"/logout"})
    public String home(HttpSession session, Model model) {
       session.removeAttribute("user");
       return "redirect:/dashboard";
    }

}
