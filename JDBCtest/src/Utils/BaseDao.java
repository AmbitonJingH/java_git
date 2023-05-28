package Utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*
* TODO:
*   封装两个方法 一个简化非DQL
*              一个简化DQL
* */
public abstract class BaseDao {
    /*
     * 封装简化非DQL语句
     *   sql  带占位符的SQL语句
     *   params  占位符的值
     *
     * */
    public int executeUpdate(String sql, Object... params) throws SQLException {
        //获取连接
        Connection connection = JDBCUtilsV2.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 1; i < params.length; i++) {
            statement.setObject(i, params[i-1]);
        }

        int rows = statement.executeUpdate();
        statement.close();
        //是否回收连接，需要考虑是不是事务
        if (connection.getAutoCommit()) {
            //没有开启事务  正常回收即可
            JDBCUtilsV2.freeConnection();
        }

        return rows;
    }

    /*
     *
     * DQL语句封装方法->返回值类型是一个实体类集合  List<T>
     *   <T> 声明一个泛型，不确定类型
     *   public <T> List<T> executeQuery(Class<T> clazz,String sql,Object... params)
     *
     *  */
    public <T> List<T> executeQuery(Class<T> clazz, String sql, Object... params) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        Connection connection = JDBCUtilsV2.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if(params!=null && params.length!=0){
            for(int i =1;i< params.length;i++){
                preparedStatement.setObject(i,params[i-1]);
            }
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        /*
         *  resuleSet:有行有列！获取数据的时候，一行一行获取！
         *            内部有一个游标，默认指向数据的第一行之前！
         *            我们可以利用next（）方法移动游标！指向数据行
         *            获取航中的列的数据！
         * */
        List<T> list = new ArrayList<>();
        while (resultSet.next()) {

            T t = clazz.getDeclaredConstructor().newInstance();
            for (int i = 1; i <= columnCount; i++) {
                Object value = resultSet.getObject(i);
                String propertyName = metaData.getColumnLabel(i);
                //反射，给对象的属性值赋值
                Field declaredField = clazz.getDeclaredField(propertyName);
                declaredField.setAccessible(true);//属性可以设置 打破private的修饰限制
                /*
                * 参数1：要复制的对象，如果属性是静态的，第一个参数可以为 null
                * 参数2：具体的属性值
                *
                * */
                declaredField.set(t,value);

            }

            list.add(t);
        }
        resultSet.close();
        preparedStatement.close();
        if(connection.getAutoCommit()){
            JDBCUtilsV2.freeConnection();
        }
        return list;
}




}
