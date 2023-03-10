package com.account_xmlioc.service.impl;

import com.account_xmlioc.dao.IAccountDao;
import com.account_xmlioc.domain.Account;
import com.account_xmlioc.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
       accountDao.updateAccount(account);

    }

    @Override
    public void deleteAccount(Integer acccountId) {

        accountDao.deleteAccount(acccountId);

    }
}
