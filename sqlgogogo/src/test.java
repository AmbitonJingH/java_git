import JDBCuntils.JDBCutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //加载驱动
      //  Class.forName("com.mysql.cj.jdbc.Driver");
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        String url = "jdbc:mysql://localhost:3306/a?serverTimezone=GMT%2B8";
//        String user = "root";
//        String password = "123456";
//        Connection connection = DriverManager.getConnection(url,user,password);
//        if(connection==null)
//            System.out.println("链接失败");
//        else
//            System.out.println("链接成功");
//
//        Statement statement = connection.createStatement();
//        String sql = "INSERT INTO S VALUES('009','黄chaoyuan','男',190,'土木')";
//        if(statement.executeUpdate(sql)>=1)
//            System.out.println("操作成功");
//        else
//            System.out.println("操作失败");
//        connection.close();



        JDBCutil jdbCutil = new JDBCutil();
        Connection conn = jdbCutil.connection();
        Statement statement = conn.createStatement();
        String sql = "INSERT INTO S VALUES('011','nhahah','男',110,'土木')";
        statement.executeUpdate(sql);
        conn.close();


    }
}
