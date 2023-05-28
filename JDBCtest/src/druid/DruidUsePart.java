package druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUsePart{
    /*
    * 直接使用代码设置连接池连接参数方式！
    *
    * 1.创建一个druid连接池对象
    *
    * 2.设置连接池参数【必须|非必须】
    *
    * 3.获取连接【通用方法，所有连接池都一样】
    *
    * 4.回收连接池【通用方法，所有连接池都一样】
    *
    * */

    public void testHard() throws SQLException {

        //连接对象池
        DruidDataSource dataSource = new DruidDataSource();

        //设置参数
        //必须  连接数据库驱动类的全限定符【注册驱动】| url | user | password
        dataSource.setUrl("jdbc:mysql://localhost:3360/atguigu");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");//帮助我们进行驱动注册和获取连接
        //非必须 初始化连接数量，最大的连接数量.....
        dataSource.setInitialSize(5);//初始化连接数量
        dataSource.setMaxActive(10);//最大连接数量

        DruidPooledConnection connection = dataSource.getConnection();
        connection.close();//如果是连接池创建的链接 close();就是回收链接
    }


    /*
    *  通过读取外部配置文件的方法，实例化druid连接池对象
    *
    * */
    @Test
    public void testSoft() throws Exception {
        //1.读取外部配置文件 Properties
        Properties properties = new Properties();
        //src下的文件，可以使用类加载器提供的方法
        InputStream stream = DruidUsePart.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(stream);
        //2.使用连接池的工具类的工程模式，创建连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();
        //数据库curd

        connection.close();
    }
}



















