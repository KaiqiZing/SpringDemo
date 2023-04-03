//package com.test;
//
//
//import com.spring_withoutAOP.service.IAccountService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spingwithoutAOP.xml")
//public class AccountServiceWithOutBenFactory {
//    @Autowired
//    @Qualifier("proxyAccountService")
//    private  IAccountService as;
//
//    @Test
//    public  void testTransfer(){
//        as.transfer("aaa","bbb",100f);
//    }
//
//}
