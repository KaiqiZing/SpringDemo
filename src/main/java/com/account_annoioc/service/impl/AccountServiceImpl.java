package com.account_annoioc.service.impl;

import com.account_annoioc.dao.IAccountDao;
import com.account_annoioc.domain.Account;
import com.account_annoioc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;


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
