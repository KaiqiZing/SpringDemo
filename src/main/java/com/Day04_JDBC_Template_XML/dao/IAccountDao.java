package com.Day04_JDBC_Template_XML.dao;

import com.Day04_JDBC_Template_XML.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {




    /**
     * 根据Id查询账户
     *
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
