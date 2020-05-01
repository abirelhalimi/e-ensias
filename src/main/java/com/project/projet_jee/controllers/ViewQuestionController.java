package com.project.projet_jee.controllers;

import com.project.projet_jee.models.Account;
import com.project.projet_jee.models.Comment;
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
import java.util.List;

@Controller
public class ViewQuestionController {

    @Autowired
    private ServiceRobot serviceRobot;

    @GetMapping(value = "/viewquestion/{questionId}")
    public String myQuestions(@PathVariable("questionId")  String id,HttpSession session,Model model) {

        Long lId= Long.parseLong(id);
        Question question=serviceRobot.getQuestionId(lId);
        model.addAttribute("question",question);
        model.addAttribute("comments",serviceRobot.getCommentsQuestion(question));

        if(session.getAttribute("user")==null){
            return "viewquestionwithout";
        }
        else{
            model.addAttribute("user",session.getAttribute("user"));
            return "viewquestion";
        }


    }

    @PostMapping(value = "/addcomment/{questionId}")
    public String addComment(@PathVariable("questionId") String id,@RequestParam String comment, HttpSession session, Model model) {

        Long lId= Long.parseLong(id);
        Question question=serviceRobot.getQuestionId(lId);
        model.addAttribute("question",question);
        model.addAttribute("comments",serviceRobot.getCommentsQuestion(question));
        model.addAttribute("user",session.getAttribute("user"));

        serviceRobot.createComment((Account)session.getAttribute("user"),comment,question);

            return "redirect:/viewquestion/"+id;



    }


}
