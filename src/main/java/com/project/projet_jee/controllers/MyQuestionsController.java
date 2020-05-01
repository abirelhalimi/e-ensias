package com.project.projet_jee.controllers;

import com.project.projet_jee.models.Account;
import com.project.projet_jee.models.Question;
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
public class MyQuestionsController {

    @Autowired
    private ServiceRobot serviceRobot;

    @GetMapping(value = {"/myquetions"})
    public String myQuestions(Model model,HttpSession session) {


        if(session.getAttribute("user")==null){
            return "redirect:/login";
        }
        else{
            model.addAttribute("user",session.getAttribute("user"));
            model.addAttribute("myQuestions",serviceRobot.getMyQuestions((Account) session.getAttribute("user")));
            return "myquestions";
        }
    }
    @GetMapping(value = "/deletequestion/{questionId}")
    public String myQuestions(@PathVariable("questionId")  String id, HttpSession session, Model model) {

        Long lId= Long.parseLong(id);
        Question question=serviceRobot.getQuestionId(lId);
        serviceRobot.deleteQuestion(question);

        return "redirect:/myquetions";


    }

}
