package com.account_annoioc.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;


/*
* 账户实体类
* */
public class Account implements Serializable  {
    private Integer id;
    private String name;
    private Float money;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
