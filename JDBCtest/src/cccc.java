import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cccc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu?serverTimezone=GMT%2B8","root","123456");
        String sql = "update t_user set nickname=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,"浩黄");
        preparedStatement.setObject(2,3);
        int rows = preparedStatement.executeUpdate();
        if (rows>=1){
            System.out.println("修改成功！");
        }else{
            System.out.println("修改失败！");
        }
        preparedStatement.close();
        connection.close();


    }
}
