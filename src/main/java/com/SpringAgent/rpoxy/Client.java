package com.SpringAgent.rpoxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 动态代理：这种代理不支持子类的代理
 *  特点：字节码随用随创建，随用随加载
 *  作用：不修改源码的基础上对方法增强
 *  分类：
 *      基于接口的动态代理
 *      基于子类的动态代理
 *  基于接口的动态代理：
 *      涉及的类：Proxy
 *      提供者：JDK官方
 *  如何创建代理对象：
 *      使用Proxy类中的newProxyInstance方法
 *  创建代理对象的要求：
 *      被代理类最少实现一个接口，如果没有则不能使用
 *  newProxyInstance方法的参数：
 *      ClassLoader：类加载器
 *          它是用于加载代理对象字节码的。和被代理对象使用相同的类加载器。固定写法。
 *      Class[]：字节码数组
 *          它是用于让代理对象和被代理对象有相同方法。固定写法。
 *      InvocationHandler：用于提供增强的代码
 *          它是让我们写如何代理。我们一般都是些一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
 *          此接口的实现类都是谁用谁写。
 */
public class Client {
    public static void main(String[] args) {
        final Producter producter = new Producter();

        IProducter iProducter = (IProducter) Proxy.newProxyInstance(
                producter.getClass().getClassLoader(),
                producter.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object ReturnValue = null;
                        Float money =(Float) args[0];
                        if ("SaleProduct".equals(method.getName())){
                            ReturnValue = method.invoke(producter, money*0.8f);
                        }
                        return ReturnValue;
                    }
                }
        );
    iProducter.SaleProduct(10000f);
    }
}
