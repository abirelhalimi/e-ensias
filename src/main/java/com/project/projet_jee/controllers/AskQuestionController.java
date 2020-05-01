package com.project.projet_jee.controllers;

import com.project.projet_jee.models.Account;
import com.project.projet_jee.models.Question;
import com.project.projet_jee.services.ServiceRobot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AskQuestionController {

    @Autowired
    private ServiceRobot serviceRobot;

    @GetMapping(value = {"/ask"})
    public String ask(Model model,HttpSession session) {

        if(session.getAttribute("user")==null){
            return "redirect:/login";
        }
        else{
            model.addAttribute("user",session.getAttribute("user"));
            return "addquestion";
        }

    }

    @PostMapping(value = {"/ask"})
    public String askPost(@RequestParam String title, String corp,String key1, String key2,String key3, HttpSession session, Model model) {


        Question question=serviceRobot.createQuestion((Account) session.getAttribute("user"),title, corp, key1,  key2,key3);
        return  "redirect:/myquetions";
    }


}
