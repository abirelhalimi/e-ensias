package com.project.projet_jee.services;

import com.project.projet_jee.models.Account;
import com.project.projet_jee.models.Comment;
import com.project.projet_jee.models.Question;

import java.util.List;

public interface ServiceRobot {
    Account createAccount(String name,String email,String password);
    Account checkEmail(String email);
    boolean checkLogin(String email, String pass);
    List<Question> getTopQuestions();

    List<Question> getMyQuestions(Account account);

    Question createQuestion(Account account,String title, String corp, String key1, String key2, String key3);
    Question getQuestionId(Long id);

    List<Comment> getCommentsQuestion(Question question);
    Comment createComment(Account account, String corp, Question question);

    void deleteQuestion(Question question);
    List<Question> getKeyQuestions(String key);
}
