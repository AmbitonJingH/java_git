package Utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoUtil {

    public int executeUpdate(String sql,Object... params) throws SQLException {

        Connection connection = JDBCUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        for(int i =1;i<= params.length;i++){
            statement.setObject(i,params[i-1]);
        }

       int rows = statement.executeUpdate();
        statement.close();

        if(connection.getAutoCommit()){
            JDBCUtil.freeConnection();
        }

        return rows;

    }


    public <T> List<T> executeQuery(Class<T> tclass,String sql,Object...params) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {


        Connection connection = JDBCUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        for(int i =1;i<= params.length;i++){
            statement.setObject(i,params[i-1]);
        }

        ResultSet resultSet = statement.executeQuery();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        List<T> list = new ArrayList<>();
        int columnCount =  resultSetMetaData.getColumnCount();

        while(resultSet.next()){

            T t = tclass.getDeclaredConstructor().newInstance();
            for(int i =1;i<=columnCount;i++){

                Object value = resultSet.getObject(i);
                if(value==null)
                    value = 0;
                String name = resultSetMetaData.getColumnLabel(i);
                Field field = tclass.getDeclaredField(name);
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

    public <T> List<T> executeQueryAdmin(Class<T> tclass,String sql,Object...params) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {


        Connection connection = JDBCUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        for(int i =1;i<= params.length;i++){
            statement.setObject(i,params[i-1]);
        }

        ResultSet resultSet = statement.executeQuery();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        List<T> list = new ArrayList<>();
        int columnCount =  resultSetMetaData.getColumnCount();

        while(resultSet.next()){

            T t = tclass.getDeclaredConstructor().newInstance();
            for(int i =1;i<=columnCount;i++){

                Object value = resultSet.getObject(i);
                String name = resultSetMetaData.getColumnLabel(i);
                Field field = tclass.getDeclaredField(name);
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


}
