package com.spring_withoutAOP.factory;

import com.account_annoioc.service.IAccountService;
import com.spring_withoutAOP.utils.TransactionManager;

// 代理对象的工厂
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager transactionManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


}
