package com.project.projet_jee.services.implementations;


import com.project.projet_jee.models.Account;
import com.project.projet_jee.models.Comment;
import com.project.projet_jee.models.Question;
import com.project.projet_jee.reporsitories.AccountRepository;
import com.project.projet_jee.reporsitories.CommentRepository;
import com.project.projet_jee.reporsitories.LassekRepository;
import com.project.projet_jee.reporsitories.QuestionRepository;
import com.project.projet_jee.services.ServiceRobot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceImp implements ServiceRobot {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    LassekRepository lassekRepository;


    @Override
    public Account createAccount(String name, String email, String password) {
        Account account=new Account();

        account.setName(name);
        account.setEmail(email);
        account.setPass(password);

        accountRepository.save(account);
        return account;
    }

    @Override
    public Account checkEmail(String email) {
        List<Account> accounts=accountRepository.findAll();
        for(Account account:accounts){
            if(account.getEmail().equals(email)) return account;
        }
        return null;
    }


    @Override
    public boolean checkLogin(String email, String pass) {
        Account account=checkEmail(email);

        if(account==null) return false;
        else{
            if(account.getPass().equals(pass)) return true;
            return false;
        }
    }

    @Override
    public List<Question> getTopQuestions() {
        List<Question> questions=null;
        questions=questionRepository.findAll();
        return questions;
    }

    @Override
    public List<Question> getMyQuestions(Account account) {
        List<Question> myQuestions=questionRepository.findAllByAccount(account);
        return myQuestions;
    }

    @Override
    public Question createQuestion(Account account,String title, String corp, String key1, String key2, String key3) {


        Question question=new Question();

        question.setAccount(account);
        question.setCorp(corp);
        question.setTitle(title);
        question.setHas_a_response(false);

        question.setKey1(key1);
        question.setKey2(key2);
        question.setKey3(key3);
        questionRepository.save(question);
        return null;
    }

    @Override
    public Question getQuestionId(Long id) {
        List<Question> questions=questionRepository.findAllById(id);

        return questions.get(0);
    }

    @Override
    public List<Comment> getCommentsQuestion(Question question) {
        return commentRepository.findAllByQuestion(question);
    }

    @Override
    public Comment createComment(Account account, String corp, Question question) {
        Comment comment=new Comment();
        comment.setAccount(account);
        comment.setCorp(corp);
        comment.setQuestion(question);
        comment.setResponse(false);
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public void deleteQuestion(Question question) {

        List<Comment> list=commentRepository.findAllByQuestion(question);
        for(Comment c:list){
            commentRepository.deleteById(c.getId());
        }
        questionRepository.delete(question);
    }

    @Override
    public List<Question> getKeyQuestions(String key) {
        key=key.toLowerCase();
        List<Question> questions=new ArrayList<Question>();
        for(Question i:questionRepository.findAll()){


            if(i.getKey1().toLowerCase().contains(key)||i.getKey2().toLowerCase().contains(key)||i.getKey3().toLowerCase().contains(key)||i.getTitle().toLowerCase().contains(key)){

                questions.add(i);
            }
        }
        return questions;
    }

}
