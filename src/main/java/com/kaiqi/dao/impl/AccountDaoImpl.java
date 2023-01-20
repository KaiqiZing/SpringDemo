package com.kaiqi.dao.impl;

import com.kaiqi.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户！！！");
    }
}
