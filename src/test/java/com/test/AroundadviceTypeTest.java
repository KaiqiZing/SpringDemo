package com.test;

import com.springadviceType.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*Spring ����ִ֪ͨ�з���*/
public class AroundadviceTypeTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("AroundadviceType.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();

    }
}
