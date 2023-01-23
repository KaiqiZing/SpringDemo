package com.ioc.service.impl;

import com.ioc.dao.IAccountDao;
import com.ioc.service.IAccountService;

/**
 * 账户的持久层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;
    public  AccountServiceImpl(){
        System.out.println("对象创建了");
    }
    @Override
    public void saveAccount() {
        accountDao.saveAccount();

    }
}
