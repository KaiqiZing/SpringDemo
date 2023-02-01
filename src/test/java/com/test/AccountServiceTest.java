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
}
