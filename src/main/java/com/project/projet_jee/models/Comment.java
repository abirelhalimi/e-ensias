package com.project.projet_jee.models;

import org.apache.catalina.User;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    @Column(name = "corp", length = 10000)
    private String corp;
    private Boolean isResponse;

    @ManyToOne
    private Account account;
    @ManyToOne
    private Question question;


    public void setId(Long id) {
        this.id = id;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public void setResponse(Boolean response) {
        isResponse = response;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getCorp() {

        return corp;
    }

    public Boolean getResponse() {
        return isResponse;
    }

    public Account getAccount() {
        return account;
    }

    public Question getQuestion() {
        return question;
    }

    public Long getId() {

        return id;
    }



}
