package com.SpringIOC.dao.impl;

import com.SpringIOC.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/*持久层实现类；
* */
@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户！！！");
    }
}
