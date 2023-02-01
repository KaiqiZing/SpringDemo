package com.bean.ui;

import com.bean.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*模拟表现层，用于调用业务层；*/
public class Clinet {
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        // 根据id获取bean对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as  = (IAccountService)ac.getBean("accountService");
        as.saveAccount();
        // 手动关闭容器
        ac.close();

    }

}
