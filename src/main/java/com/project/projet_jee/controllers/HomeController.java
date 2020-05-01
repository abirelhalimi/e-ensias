package com.project.projet_jee.controllers;

import com.project.projet_jee.models.Account;
import com.project.projet_jee.services.ServiceRobot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private ServiceRobot serviceRobot;

    @GetMapping(value = {"/"})
    public String defaultUrl() {
        return "redirect:/dashboard";
    }


    @GetMapping(value = {"/dashboard"})
    public String home(HttpSession session, Model model) {
        model.addAttribute("topQuestions",serviceRobot.getTopQuestions());
        if(session.getAttribute("user")==null){
            return "dashboard";
        }
        else{
            model.addAttribute("user",session.getAttribute("user"));
            return "dashboard_connected";
        }
    }

    @GetMapping(value = {"/lassek"})
    public String lassek(HttpSession session, Model model) {

        if(session.getAttribute("user")==null){
            return "redirect:/login";
        }
        else{
            model.addAttribute("user",session.getAttribute("user"));
            return "elasseqconnected";
        }
    }
    @GetMapping(value = {"/courses"})
    public String course(HttpSession session, Model model) {

        if(session.getAttribute("user")==null){
            return "redirect:/login";
        }
        else{
            model.addAttribute("user",session.getAttribute("user"));
            return "coursesconnected";
        }
    }
    @GetMapping(value = {"/prof"})
    public String prof(HttpSession session, Model model) {
        if(session.getAttribute("user")==null){
            return "redirect:/login";
        }
        else{
            model.addAttribute("user",session.getAttribute("user"));
            return "prof";
        }

    }

    @PostMapping(value = {"/search"})
    public String search(@RequestParam String key, HttpSession session, Model model) {
        model.addAttribute("topQuestions",serviceRobot.getKeyQuestions(key));
        model.addAttribute("message","results of looking for key word: '"+key+"'");
        if(session.getAttribute("user")==null){
            return "dashboard";
        }
        else{
            model.addAttribute("user",session.getAttribute("user"));
            return "dashboard_connected";
        }
    }
}
