package Dao;

import JDBCuntils.JDBCutil;
import Model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class studentDao {
    public void zhuceStudent(Student s) throws SQLException {
        JDBCutil jdbCutil = new JDBCutil();
        Connection connection = jdbCutil.connection();
        String sql ="INSERT INTO student(sno,sname,major,username,password,numofborrow)"+"VALUES("+"?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,s.getSno());
        preparedStatement.setString(2,s.getSname());
        preparedStatement.setString(3,s.getMajor());
        preparedStatement.setString(4,s.getUsername());
        preparedStatement.setString(5,s.getPassword());
        preparedStatement.setInt(6,s.getNumOfBorrow());
        preparedStatement.execute();
    }

}
