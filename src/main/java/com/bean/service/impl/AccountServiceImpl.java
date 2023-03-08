package com.bean.service.impl;

import com.bean.service.IAccountService;
import com.kaiqi.dao.IAccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountServiceImpl implements IAccountService {
    public AccountServiceImpl(){
        System.out.println("构造函数---对象创建了");
    }

    public void saveAccount(){
        System.out.println("save中的saveaccount方法被执行了");

    }

    public void init(){
        System.out.println("对象初始化了");

    }
    public void destory(){
        System.out.println("对象销毁类");
    }

}
