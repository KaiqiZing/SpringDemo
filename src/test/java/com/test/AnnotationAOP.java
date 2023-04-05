package com.test;

import com.springadviceType.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*Spring����ע���AOP����*/
public class AnnotationAOP {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("AnnotationAOP.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();

    }
}
