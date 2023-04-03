package com.test;

import com.springadviceType.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPadviceType {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("adviceType.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();

    }
}
