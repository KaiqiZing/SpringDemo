package com.Day04_JDBC_Template_XML.service.impl;

import com.Day04_JDBC_Template_XML.dao.IAccountDao;
import com.Day04_JDBC_Template_XML.domain.Account;
import com.Day04_JDBC_Template_XML.service.IAccountService;

import java.util.List;

/**
 * 账户的业务层实现类
 *
 * 事务控制应该都是在业务层
 */
public class AccountServiceImpl implements IAccountService{

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }




    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);

    }



    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
            //2.1根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5更新转出账户
            accountDao.updateAccount(source);

//            int i=1/0;   // 此处是事务控制，校验事务是否生效

            //2.6更新转入账户
            accountDao.updateAccount(target);

        System.out.println("transfer....end");

    }
}
