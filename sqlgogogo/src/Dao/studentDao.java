package Dao;

import JDBCuntils.JDBCutil;
import Model.Book;
import Model.Student;
import Model.Teacher;

import java.sql.*;

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
    public void loginStudent(Student s)throws SQLException{
        JDBCutil jdbCutil = new JDBCutil();
        Connection connection = jdbCutil.connection();
        String sql = "SELECT COUNT(1) AS num FROM student WHERE username=? AND PASSWORD=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,s.getUsername());
        statement.setString(2,s.getPassword());
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        if(resultSet.getInt("num")>=1)
            System.out.println("登录成功！");
        else
            System.out.println("登录失败！");
    }

    public void searchBook() throws SQLException {
        JDBCutil jdbCutil = new JDBCutil();
        Connection connection = jdbCutil.connection();
        String sql = "SELECT * FROM library.book;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Book book = new Book();
            book.setBno(resultSet.getString("bno"));
            book.setBname(resultSet.getString("bname"));
            book.setAmount(resultSet.getInt("amount"));
            System.out.println(book.toString());
        }

    }


}
