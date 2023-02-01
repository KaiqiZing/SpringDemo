package com.SpringIOC.dao.impl;

import com.SpringIOC.dao.IAccountDao;
import org.springframework.stereotype.Repository;


@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    @Override
    public void saveAccount() {
        System.out.println("保护了账户222222");

    }
}
