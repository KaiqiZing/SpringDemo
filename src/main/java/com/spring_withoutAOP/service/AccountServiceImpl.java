package com.spring_withoutAOP.service;

import com.spring_withoutAOP.dao.impl.IAccountDao;
import com.spring_withoutAOP.domain.Account;
import com.spring_withoutAOP.utils.TransactionManager;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements IAccountService{
    private IAccountDao iAccountDao;
    public TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setiAccountDao(IAccountDao iAccountDao) {
        this.iAccountDao = iAccountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            transactionManager.beginTransaction();
            List<Account> accounts = iAccountDao.findAllAccount();
            transactionManager.commit();
            return accounts;
        } catch (Exception e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            transactionManager.beginTransaction();
            Account accounts = iAccountDao.findAccountById(accountId);
            transactionManager.commit();
            return accounts;
        } catch (SQLException e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            transactionManager.beginTransaction();
            iAccountDao.saveAccount(account);
            transactionManager.commit();
        } catch (SQLException e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            transactionManager.beginTransaction();
            iAccountDao.updateAccount(account);
            transactionManager.commit();
        } catch (SQLException e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }
    @Override
    public void deleteAccount(Integer acccountId) {
        try {
            transactionManager.beginTransaction();
            iAccountDao.deleteAccount(acccountId);
            transactionManager.commit();
        } catch (SQLException e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            transactionManager.beginTransaction();
            System.out.println("测试transfer结果。。。");
            Account source = iAccountDao.findAccountByName(sourceName);        //2.1根据名称查询转出账户
            //2.2根据名称查询转入账户
            Account target = iAccountDao.findAccountByName(targetName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5更新转出账户
            iAccountDao.updateAccount(source);
            int i = 1/0;  //java.lang.ArithmeticException: / by zero PRODUCT ERROR EXPLAIN TRANSACTION DEAL IS SUCCESS
            //2.6更新转入账户
            iAccountDao.updateAccount(target);
            transactionManager.commit();
        } catch (SQLException e) {
            transactionManager.rollback();
            e.printStackTrace();
        }finally {
            transactionManager.release();
        }


    }
}
