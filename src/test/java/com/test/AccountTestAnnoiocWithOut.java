package com.test;

import com.annoioc_without.domain.Account;
import com.annoioc_without.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 * Spring整合junit的配置
 *      1、导入spring整合junit的jar(坐标)
 *      2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *             @Runwith
 *      3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration
 *                  locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                  classes：指定注解类所在地位置
 *
 *   当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 *
 *
 *   junit单元测试
 *      1.junit集成了一个main方法，该方法就会判断当前测试类中哪些方法有@Test注解，Junit就让有Test注解的方法执行
 *      2.Junit不会管我们是否采用spring框架，在执行测试方法时，也不知道是否使用了框架，所以不会读取配置文件/配置类创建spring核心容器
 *      3.当测试方法执行时，没有IOC容器，就算写了AutoWired注解也无法实现注入
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
/*locations是另一种写法*/
public class AccountTestAnnoiocWithOut {
    @Autowired
    private IAccountService as = null;

/*
    非Autowired写法
    @Test
    public void testFindAll(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
*/




    @Test
    public void testFindAll(){

        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

}
