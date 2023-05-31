package Demo;

import Utils.BaseDao;
import Utils.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class test extends BaseDao {

   @Test
   public void test() throws SQLException {
       Timestamp date = new Timestamp(System.currentTimeMillis());
       Timestamp date1 = new Timestamp(System.currentTimeMillis()+1000);
       String sql = "insert into borrow(uno,bno,borrowTime,returnTime) values(?,?,?,?)";
       executeUpdate(sql,11,2,date,date1);
   }

}
