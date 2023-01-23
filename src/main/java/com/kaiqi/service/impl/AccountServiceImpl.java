package com.kaiqi.service.impl;

import com.kaiqi.dao.IAccountDao;
import com.kaiqi.dao.impl.AccountDaoImpl;
import com.kaiqi.factory.BeanFactory;
import com.kaiqi.service.IAccountService;

/**
 * 账户的持久层实现类
 */
public class AccountServiceImpl implements IAccountService {
//    private IAccountDao accountDao = new AccountDaoImpl();
    private  IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    @Override
    public void saveAccount() {
        accountDao.saveAccount();

    }
}
