package com.ioc.ui;

import com.ioc.dao.IAccountDao;
import com.ioc.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * 获取spring的Ioc核心容器，并根据id获取对象 （inversion of control==控制反转）
 * 主要用来解决程序间的依赖关系
 *
 * ApplicationContext的三个常用实现类：
 *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)
 *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
 *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的，是明天的内容。
 *
 * 核心容器的两个接口引发出的问题：
 *  ApplicationContext:     单例对象适用              采用此接口
 *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
 *
 *  BeanFactory:            多例对象使用
 *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
 */
public class Clinet {

    public static void main(String[] args) {

        // 获取核心容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //regard id get bean object
//        IAccountService iAccountService = (IAccountService)applicationContext.getBean("accountService");
        IAccountService iAccountService = applicationContext.getBean("accountService", IAccountService.class) ; // 获取到object类型进行强制转换
        IAccountDao iAccountDao = applicationContext.getBean("accountDao", IAccountDao.class); // 获取到字节码文件进行强转
        System.out.println("ApplicationContext"+iAccountDao);
        System.out.println("Applicati+onContext"+ iAccountService);


        // BeanFactory=====
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService iAccountService1 = (IAccountService)factory.getBean("accountService");
        System.out.println("BeanFactory:"+iAccountService1);
    }
}
