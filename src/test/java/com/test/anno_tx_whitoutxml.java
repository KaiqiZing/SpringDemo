package com.test;


import annoConfig.SpringConfiguration;
import com.anno_tx_whitoutxml.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringConfiguration.class)
public class anno_tx_whitoutxml {
    @Autowired
    private IAccountService iAccountService;
    @Test
    public void testTranfer(){
        iAccountService.transfer("aaa","bbb",100f);
    }
}
