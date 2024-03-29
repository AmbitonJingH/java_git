package Utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao {

    public int executeUpdate(String sql,Object... params) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        connection.setAutoCommit(true);
        PreparedStatement statement = connection.prepareStatement(sql);

            for(int i =1;i<= params.length;i++) {
                statement.setObject(i, params[i - 1]);
            }

           int rows = statement.executeUpdate();
            statement.close();

        //System.out.println(connection.getAutoCommit());
        if(connection.getAutoCommit()){
            JDBCUtil.freeConnection();
        }
        return rows;
    }
    public int executeUpdate1(String sql,Object... params) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        connection.setAutoCommit(false);
        PreparedStatement statement = connection.prepareStatement(sql);

        for(int i =1;i<= params.length;i++) {
            statement.setObject(i, params[i - 1]);
        }

        int rows = statement.executeUpdate();
        statement.close();

      //  System.out.println(connection.getAutoCommit());
//        if(connection.getAutoCommit()){
//            JDBCUtil.freeConnection();
//        }
        return rows;
    }

    public <T> List<T> executeQuery(Class<T> tclass, String sql, Object... params) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Connection connection = JDBCUtil.getConnection();
        connection.setAutoCommit(true);
        PreparedStatement statement = connection.prepareStatement(sql);

        for(int i =1;i<= params.length;i++){
            statement.setObject(i,params[i-1]);
        }

        ResultSet resultSet = statement.executeQuery();
        List<T> list = new ArrayList<>();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();

        while(resultSet.next()){
            T t = tclass.getDeclaredConstructor().newInstance();

            for(int i=1;i<=columnCount;i++) {
                Object value = resultSet.getObject(i);
                String properName = resultSetMetaData.getColumnLabel(i);
                Field field = tclass.getDeclaredField(properName);
                field.setAccessible(true);
                field.set(t,value);
            }

            list.add(t);
        }
        resultSet.close();
        statement.close();

        if(connection.getAutoCommit()){
            JDBCUtil.freeConnection();
        }

        return list;
    }


    public <T> List<T> executeQuery1(Class<T> tclass, String sql, Object... params) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Connection connection = JDBCUtil.getConnection();
        connection.setAutoCommit(false);
        PreparedStatement statement = connection.prepareStatement(sql);

        for(int i =1;i<= params.length;i++){
            statement.setObject(i,params[i-1]);
        }

        ResultSet resultSet = statement.executeQuery();
        List<T> list = new ArrayList<>();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();

        while(resultSet.next()){
            T t = tclass.getDeclaredConstructor().newInstance();

            for(int i=1;i<=columnCount;i++) {
                Object value = resultSet.getObject(i);
                String properName = resultSetMetaData.getColumnLabel(i);
                Field field = tclass.getDeclaredField(properName);
                field.setAccessible(true);
                field.set(t,value);
            }

            list.add(t);
        }
        resultSet.close();
        statement.close();

//        if(connection.getAutoCommit()){
//            JDBCUtil.freeConnection();
//        }

        return list;
    }
}
