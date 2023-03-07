package com.kaiqi.factory;

import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
* 创建一个bean对象的工厂；创建service和dao对象
*   1.配置文件中配置service and dao 唯一标识：全限定类名；
*   2. 通过读取配置文件中的配置内容，反射创建对象；
*   3.创建properties文件设置为配置文件或者使用xml文件；
*
* */
// 优化多列模式到单例模式
// 工厂模式的好处就是解耦，解耦的目的就是减少或者销户编译时报错的可能性，保证程序能够正常编译；

public class BeanFactory {
    /*
    * 用工厂模式创建对象，读取配置文件信息，反射到需要的对象中
    * 1.定义一个properties;
    * 2.*/
    private static Properties props;
    // 定义一个Map 用于存放我们要创建的对象，我们把它称之为容器；
    private static Map<String, Object> beans;
    static {
        try {
            props =  new Properties(); // 创建properties对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<>();
            // 取出配置文件中所有的key；
            Enumeration keys = props.keys();
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanpath = props.getProperty(key); // 获取到配置文件定义的数据
                Object value = Class.forName(beanpath).newInstance();  // 加载类到内存中并创建对象
                beans.put(key, value);
            }

        } catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties失败！");

        }
    }

    public static Object getBean(String beanName){

        return beans.get(beanName);
    }

}
