package com.test;


import com.spring_withoutAOP.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spingwithoutAOP.xml")
public class AccountServiceTestWtihoutAOp {


    //未加事物之前的代码逻辑
    @Autowired
    private IAccountService as;
    @Test
    public void testTransfer(){
        as.transfer("bbb","aaa",100f);
    }

/*    @Test
    public void findAllAccount(){
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);

        }
    }*/

}
