package com.test;

import com.account_xmlioc.domain.Account;
import com.account_xmlioc.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/*单元测试
* */
public class AccountServiceTest {
    @Test
    public void testFindAll(){
        // 获取对象；
        ApplicationContext ac = new ClassPathXmlApplicationContext("account_xmlioc.xml");
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        // 获取到业务层对象；
        IAccountService as = (IAccountService)ac.getBean("accountService");
        // 执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //1.获取容易
        ApplicationContext ac = new ClassPathXmlApplicationContext("account_xmlioc.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        //1.获取容易
        ApplicationContext ac = new ClassPathXmlApplicationContext("account_xmlioc.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        as.saveAccount(account);

    }

/*    @Test
    public void testUpdate() {
        //1.获取容易
        ApplicationContext ac = new ClassPathXmlApplicationContext("account_xmlioc.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }*/

/*    @Test
    public void testDelete() {
        //1.获取容易
        ApplicationContext ac = new ClassPathXmlApplicationContext("account_xmlioc.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        as.deleteAccount(4);
    }*/

}
