package com.kaiqi.dao.impl;

import com.kaiqi.dao.IAccountDao;
/*持久层实现类；
* */
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户！！！");
    }
}
