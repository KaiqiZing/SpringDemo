package com.test;

import com.account_annoioc.domain.Account;
import com.account_annoioc.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/*单元测试
* */
public class AccountServiceTest {
    @Test
    public void testFindAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("account_annoioc.xml");
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        IAccountService as = (IAccountService)ac.getBean("accountService");

        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindone(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("account_annoioc.xml");
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        IAccountService as = (IAccountService)ac.getBean("accountService");
        Account account = as.findAccountById(1);
        System.out.println("查询指定参数："+ account);

    }


    @Test
    public  void testSave(){
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);

    }
    @Test
    public void testUpdate(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("account_annoioc.xml");
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        IAccountService as = (IAccountService)ac.getBean("accountService");
        Account account = as.findAccountById(4);
        account.setMoney(233f);
        as.updateAccount(account);

    }

    @Test
    public void testDelete(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("account_annoioc.xml");
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        IAccountService as = (IAccountService)ac.getBean("accountService");
        as.deleteAccount(4);


    }

}
