package com.test;

import com.Day04_JDBC_Template_XML.domain.Account;
import com.Day04_JDBC_Template_XML.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用Junit单元测试：测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Day04_JDBC_Template_XML.xml")
public class TEST_JDBC_Template_XML {

    @Autowired
    private IAccountService as;

    @Test
    public  void testTransfer(){
        as.transfer("aaa","bbb",100f);

    }

    @Test
    public void getonedata(){
        Account account = as.findAccountById(1);
        System.out.println(account);
    }





}
