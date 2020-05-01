package com.project.projet_jee.models;

import javax.persistence.*;

@Entity
public class KeyWord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String value;

    @ManyToOne
    Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
