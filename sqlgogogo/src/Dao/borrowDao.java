package Dao;

import Utils.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class borrowDao {

    public void borrowBook() throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        studentDao studentDao = new studentDao();
        try{

           // studentDao.borrowBook();

        }catch (Exception e){

        }
    }
}
