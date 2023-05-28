package transactionNew;

import Utils.JDBCUtilsV2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankDao {


    /*
    * 加钱的数据库操作方法（jdbc）
    *   account 加钱的行号
    *   money   加钱的金额
    * */
    public void add(String account,int money) throws ClassNotFoundException, SQLException {

        Connection connection = JDBCUtilsV2.getConnection();
        String sql = "update t_bank set money = money + ? where account = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setObject(1,money);
        statement.setObject(2,account);

        statement.executeUpdate();

        statement.close();


        System.out.println("转账成功！");

    }

    /*
     * 减钱的数据库操作方法（jdbc）
     *   account 减钱的行号
     *   money   减钱的金额
     * */
    public void sub(String account,int money) throws ClassNotFoundException, SQLException {

        Connection connection = JDBCUtilsV2.getConnection();
        String sql = "update t_bank set money = money - ? where account = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setObject(1,money);
        statement.setObject(2,account);

        statement.executeUpdate();

        statement.close();

        System.out.println("转账成功！");
    }












}
