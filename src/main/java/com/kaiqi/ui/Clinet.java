package com.kaiqi.ui;

import com.kaiqi.factory.BeanFactory;
import com.kaiqi.service.IAccountService;
import com.kaiqi.service.impl.AccountServiceImpl;
/*模拟表现层，用于调用业务层；*/
public class Clinet {
    public static void main(String[] args) {
//        IAccountService as  = new AccountServiceImpl();
        // getBean("accountService") 使用获取class对象的方法，其中class.forName("全类名")返回class对象
        IAccountService  as = (IAccountService) BeanFactory.getBean("accountService"); // 调用方法
        as.saveAccount();// dao→service→ui client，last output dao of value;
    }
}
