package com.project.projet_jee.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String title;
    @Column(name = "corp", length = 10000)
    private  String corp;
    private Boolean hasResponse;
    private String key1;
    private String key2;
    private String key3;

    @ManyToOne
    private Account account;

    public Boolean getHasResponse() {
        return hasResponse;
    }

    public void setHasResponse(Boolean hasResponse) {
        this.hasResponse = hasResponse;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public void setHas_a_response(Boolean has_a_response) {
        this.hasResponse = has_a_response;
    }



    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCorp() {
        return corp;
    }

    public Boolean getHas_a_response() {
        return hasResponse;
    }


    public Account getAccount() {
        return account;
    }

}
