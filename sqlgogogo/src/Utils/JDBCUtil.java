package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource dataSource = null;
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();
    static {
        Properties properties = new Properties();
        InputStream stream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = tl.get();
        if(connection==null){
            connection = dataSource.getConnection();
            tl.set(connection);
        }
        return connection;

    }
    public static void freeConnection() throws SQLException {

        Connection connection = tl.get();
        if(connection!=null){
            tl.remove();
            connection.setAutoCommit(true);
            connection.close();
        }

    }


}
