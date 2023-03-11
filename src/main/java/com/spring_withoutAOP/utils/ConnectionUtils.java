package com.spring_withoutAOP.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*链接数据库工具
* */
public class ConnectionUtils {

        private ThreadLocal<Connection> tl = new ThreadLocal<>();
        private DataSource dataSource;
        public void setDataSource(DataSource dataSource){
            this.dataSource = dataSource;
        }

        // 获取当前线程上的链接
    public Connection getThreadConnection() throws SQLException {
            Connection conn = tl.get();
            if (conn == null){
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            return conn; // 返回当前线程上的链接
    }

    public void removeConnection(){
            tl.remove();
    }
}
