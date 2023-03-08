package com.SpringInjection.service.impl;

import com.SpringInjection.service.IAccountService;

import java.util.Date;

/**
 * 账户的持久层实现类
 */
public class AccountServiceImpl implements IAccountService {
    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name,Integer age,Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void  saveAccount(){
        System.out.println("=======构造函数的注入====");
        System.out.println("service中的saveAccount方法执行了。。。"+name+","+age+","+birthday);
        System.out.println("在获取bean对象时，注入数据是必须的操作，否则对象无法创建成功");
    }


}
