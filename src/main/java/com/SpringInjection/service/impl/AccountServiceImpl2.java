package com.SpringInjection.service.impl;

import com.SpringInjection.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl2 implements IAccountService {
    private String name;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private Date birthday;


    @Override
    public void saveAccount() {
        System.out.println("set方法的注入方式====");
        System.out.println("service2方法执行了set方法的注入："+name+age+birthday);
    }
}
