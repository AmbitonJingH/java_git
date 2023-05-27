import org.junit.Test;

import java.sql.*;

public class PSOtherPart {

    /*
    * TODO:
    *   t_user插入一条数据！并且获取数据库的自增长的主键！
    *
    * TODO:使用总结
    *   1.创建prepareStatement的时候，告知，携带回数据库自增长的主键(sql,PrepareStatement.RETURN_GENERATED_KEYS)
    *   2.获取司机装主键值的结果集对象
    *
    *
    *
    * */
    @Test
    public void test1() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu","root","123456");
        String sql = "insert into t_user(account,password,nickname) values(?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS );
        preparedStatement.setObject(1,"akc");
        preparedStatement.setObject(2,"akc");
        preparedStatement.setObject(3,"AK");
        int rows = preparedStatement.executeUpdate();
        if(rows>=1){
            System.out.println("插入成功！");

            //可以获取回显的主键
            //获取司机装主键的结果对象 ， 一行一列，id = 值
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int id = resultSet.getInt(1);
            System.out.println("id = "+id);

        }else{
            System.out.println("插入失败！");
        }
        preparedStatement.close();
        connection.close();
    }
/*
* TODO:总结批量插入
*   1.  路径后面添加?rewriteBatchedStatements=true  允许批量插入
*   2.  insert into values[必须写] 语句不能添加; 结束
*   3.  不是执行语句，是批量添加，addBatch();
*   4.  遍历加载完毕后，统一批量执行 executeBatch();
* */
    @Test
    public void testBatchInsert() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu?rewriteBatchedStatements=true","root","123456");
        String sql = "insert into t_user(account,password,nickname) values(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();

        for (int i = 0;i<10000;i++) {
            preparedStatement.setObject(1, "akcc"+i);
            preparedStatement.setObject(2, "akcc"+i);
            preparedStatement.setObject(3, "AKk"+i);

            preparedStatement.addBatch();//不执行  追加到value后面！
        }

        preparedStatement.executeBatch();//执行批量操作！

        long end = System.currentTimeMillis();

        System.out.println("消耗时间为："+(end-start)+" s");

        preparedStatement.close();
        connection.close();
    }












}
