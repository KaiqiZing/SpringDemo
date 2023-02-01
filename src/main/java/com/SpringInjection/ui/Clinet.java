package com.SpringInjection.ui;

import com.SpringInjection.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*模拟表现层，用于调用业务层；*/
public class Clinet {
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        // 根据id获取bean对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beaninjection.xml");
        IAccountService as  = (IAccountService)ac.getBean("accountService");
        IAccountService as2  = (IAccountService)ac.getBean("accountService2");
        IAccountService as3 = (IAccountService)ac.getBean("accountService3");
        as3.saveAccount();
        as2.saveAccount();
        as.saveAccount();
        ac.close();

    }

}
