package com.spring_withoutAOP.factory;

import com.account_annoioc.service.IAccountService;
import com.spring_withoutAOP.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 代理对象的工厂，这里要搞清楚一个事情就是谁是生产者谁是消费者，其中service生产者调用dao这个消费者作为结果的输出
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager transactionManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


    // 这里的service是服务商 需要 找个代理


    public IAccountService getAccountService() {

        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("test".equals(method.getName())){
                            return method.invoke(accountService, args);
                        }
                        Object rtvalue = null;
                        try{
                            transactionManager.beginTransaction();
                            rtvalue = method.invoke(accountService, args);
                            transactionManager.commit();
                            return rtvalue;
                        } catch (Exception e){
                            transactionManager.rollback();
                        } finally {
                            transactionManager.release();
                        }
                        return rtvalue;
                    }
                });
    }
}
