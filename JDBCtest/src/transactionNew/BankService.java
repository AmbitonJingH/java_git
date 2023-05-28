package transactionNew;

import Utils.JDBCUtilsV2;
import org.junit.Test;
import transactionNew.BankDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankService {

    @Test
    public void test() throws SQLException, ClassNotFoundException {
        transfer("lvdandan","ergouzi",500);
    }

    /*
    * TODO:
    *       事务添加是在业务方法中!
    *       利用try catch代码块，开启事务提交事务，事务回滚！
    *       将connection传入dao层即可   dao只负责使用，不要close();
    *
    *
    *
    * */
    public void transfer(String addAccount,String subAccount,int money) throws SQLException, ClassNotFoundException {

       Connection connection = JDBCUtilsV2.getConnection();

        BankDao bankDao = new BankDao();

        try{
            //开启事务
            connection.setAutoCommit(false);//关闭事务自动提交
            //执行数据库操作
            bankDao.add(addAccount,money);
            System.out.println("---------------");
            bankDao.sub(subAccount,money);
            //事务提交
            connection.commit();
        }catch (Exception e){
            //事务回滚
            connection.rollback();

            //抛出
            throw e;
        }finally {
            JDBCUtilsV2.freeConnection();
        }
        //一个事务的最基本要求，必须是同一个连接对象 connection
        //一个转账方法，属于一个事务-(加钱 减钱)



    }
}
