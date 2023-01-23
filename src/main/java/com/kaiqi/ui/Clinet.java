package com.kaiqi.ui;

import com.kaiqi.factory.BeanFactory;
import com.kaiqi.service.IAccountService;
import com.kaiqi.service.impl.AccountServiceImpl;
/*模拟表现层，用于调用业务层；*/
public class Clinet {
    public static void main(String[] args) {
//        IAccountService as  = new AccountServiceImpl();
        IAccountService  as = (IAccountService) BeanFactory.getBean("accountService"); // 调用方法对象
        as.saveAccount();// dao→service→ui client，last output dao of value;
    }
}
