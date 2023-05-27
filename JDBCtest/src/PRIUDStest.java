import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PRIUDStest {

    @Test
    public void testInsert() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu?serverTimezone=GMT%2B8","root","123456");
        String sql = "insert into t_user(id,account,password,nickname) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,4);
        preparedStatement.setObject(2,"666");
        preparedStatement.setObject(3,"123");
        preparedStatement.setObject(4,"ok");
        int rows = preparedStatement.executeUpdate();
        if(rows>=1){
            System.out.println("插入成功！");
        }else{
            System.out.println("插入失败！");
        }
        preparedStatement.close();
        connection.close();
    }
    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
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
    @Test
    public void testDelete() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu?serverTimezone=GMT%2B8", "root", "123456");
        String sql = "delete from t_user where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,4);
        int rows = preparedStatement.executeUpdate();
        if (rows>=1){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }
        preparedStatement.close();
        connection.close();

    }
    @Test
    public void testSelect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu?serverTimezone=GMT%2B8","root","123456");
        String sql = "select nickname from t_user where id<?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,5);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getObject("nickname"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
    @Test
    public void testSelect2() throws ClassNotFoundException, SQLException {
        /*
        *
        * 数据库-->resultSet-->java-->一行-->map(key=列名,value=列的内容)-->List<Map> list
        *
        * 实现思路：
        *       遍历行数据，一行对应一个map！获取一行的列名和对应的列的属性，装配即可!
        *       将map涨到一个集合就可以；1！
        *
        * 难点：
        *       如何获取列的名称？
        *
        *
        *
        *
        * */
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu","root","123456");
        String sql = "select id,account,password,nickname from t_user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        /*
        *  resuleSet:有行有列！获取数据的时候，一行一行获取！
        *            内部有一个游标，默认指向数据的第一行之前！
        *            我们可以利用next（）方法移动游标！指向数据行
        *            获取航中的列的数据！
        * */
        List<Map> list = new ArrayList<>();
        while (resultSet.next()){

            Map map = new HashMap();
            for(int i = 1;i<=columnCount;i++){
                Object value = resultSet.getObject(i);
                String columnLable = metaData.getColumnLabel(i);
                //metaData.getColumnLabel() 可读别名
                map.put(columnLable,value);
            }
//          纯手动取值！！！！
//            map.put("id",resultSet.getObject("id"));
//            map.put("account",resultSet.getObject("account"));
//            map.put("password",resultSet.getObject("password"));
//            map.put("nickname",resultSet.getObject("nickname"));
            list.add(map);
        }
        System.out.println("list ="+list);
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

}
