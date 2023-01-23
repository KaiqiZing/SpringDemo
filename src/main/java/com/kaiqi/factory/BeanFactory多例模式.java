package com.kaiqi.factory;

import java.io.InputStream;
import java.util.Properties;

/*
* 创建一个bean对象的工厂；创建service和dao对象
*   1.配置文件中配置service and dao 唯一标识：全限定类名；
*   2. 通过读取配置文件中的配置内容，反射创建对象；
*   3.创建properties文件设置为配置文件或者使用xml文件；
*
* */
public class BeanFactory多例模式 {
    /*
    * 用工厂模式创建对象，读取配置文件信息，反射到需要的对象中
    * 1.定义一个properties;
    * 2.*/
    private static Properties props;
    static {
        try {
            props = new Properties();
            InputStream in  = BeanFactory多例模式.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
        } catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties失败！");

        }
    }

    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanpath = props.getProperty(beanName);
            bean = Class.forName(beanpath).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }

}
