package cn.easybuy.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static final Logger logger = Logger.getLogger(JDBCUtil.class);
    private static DataSource dataSource;

   /* static {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/easyBuy");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }*/
   static {
       InputStream is = null;
       try {
           // 创建Properties类对象
           Properties properties = new Properties();
           // 读取properties属性文件到输入流中
           is = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
           // 从输入流中加载属性列表
           properties.load(is);

           dataSource = DruidDataSourceFactory.createDataSource(properties);

       } catch (ClassNotFoundException cnfe) {
           cnfe.printStackTrace();
       } catch (Exception ex) {
           ex.printStackTrace();
       }finally {
           try {
               is.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }

    //获取连接
    public static Connection openConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("connection opened:" + connection.hashCode());
        return connection;
    }

    //关闭连接
    public static void closeConnection(Connection connection) {
        logger.info("connection closed:" + connection.hashCode());
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
