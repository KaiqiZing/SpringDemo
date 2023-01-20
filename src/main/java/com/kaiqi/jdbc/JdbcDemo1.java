package com.kaiqi.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 *      耦合：程序间的依赖关系
 *          包括：
 *              类之间的依赖
 *              方法间的依赖
 *      解耦：
 *          降低程序间的依赖关系
 *      实际开发中：
 *          应该做到：编译期不依赖，运行时才依赖。
 *      解耦的思路：
 *          第一步：使用反射来创建对象，而避免使用new关键字。
 *          第二步：通过读取配置文件来获取要创建的对象全限定类名
 *          select * from course;
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        /*1.注册驱动，2.获取链接，3.获取操作数据库的与处理对象，4.执行SQL，得到结果集；5.遍历结果集，6.释放资源*/
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.163:3306/test","root","root");
        PreparedStatement preparedStatement = conn.prepareStatement("select * from course");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("courseid"));
        }
        resultSet.close();
        preparedStatement.close();
        conn.close();

    }
}
