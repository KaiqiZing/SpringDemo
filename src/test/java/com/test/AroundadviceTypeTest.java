package com.test;

import com.springadviceType.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*Spring 环绕通知执行方法*/
public class AroundadviceTypeTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("AroundadviceType.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();

    }
}
