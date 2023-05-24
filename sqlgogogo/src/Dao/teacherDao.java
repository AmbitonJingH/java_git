package Dao;

import JDBCuntils.JDBCutil;
import Model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class teacherDao {
    public void zhuceTeacher(Teacher t) throws SQLException {
        JDBCutil jdbCutil = new JDBCutil();
        Connection connection = jdbCutil.connection();
        String sql ="INSERT INTO teacher(tno,tname,title,username,password,numofborrow)"+"VALUES("+"?,?,?,?,?,?)";
        String sql1 = "CREATE USER ?@'localhost' IDENTIFIED BY ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        preparedStatement.setString(1,t.getTno());
        preparedStatement.setString(2,t.getTname());
        preparedStatement.setString(3,t.getTitle());
        preparedStatement.setString(4,t.getUsername());
        preparedStatement.setString(5,t.getPassword());
        preparedStatement.setInt(6,t.getNumOfBorrow());
        preparedStatement1.setString(1,t.getUsername());
        preparedStatement1.setString(2,t.getPassword());
        preparedStatement.execute();
        preparedStatement1.execute();
    }

//    public void loginTeacher(Teacher t)throws SQLException{
//        JDBCutil jdbCutil = new JDBCutil();
//        Connection connection = jdbCutil.connection(t.getUsername(),t.getPassword());
//        if (connection == null)
//            System.out.println("登录失败");
//        else
//            System.out.println("登陆成功！");
//    }
}
