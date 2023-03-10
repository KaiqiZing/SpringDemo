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
            System.out.println("??????transfer???????????????");
            Account source = iAccountDao.findAccountByName(sourceName);        //2.1??????????????????????????????
            //2.2??????????????????????????????
            Account target = iAccountDao.findAccountByName(targetName);
            //2.3??????????????????
            source.setMoney(source.getMoney()-money);
            //2.4??????????????????
            target.setMoney(target.getMoney()+money);
            //2.5??????????????????
            iAccountDao.updateAccount(source);
            int i = 1/0;  //java.lang.ArithmeticException: / by zero PRODUCT ERROR EXPLAIN TRANSACTION DEAL IS SUCCESS
            //2.6??????????????????
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
