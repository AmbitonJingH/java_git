package Dao;

import Model.Course;
import Model.User;
import Utils.DaoUtil;
import Utils.JDBCUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SystemDao extends DaoUtil {

    private static String username;
    private static String upassword;

    public boolean login(User user) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        boolean success;

        String sql = "select * from users where username=? and upassword=?";
        List<User> users = executeQuery(User.class, sql, user.getUsername(), user.getUpassword());
       // User user1 = users.get(0);
        if(!users.isEmpty()){
            System.out.println("登陆成功");
            success = true;
            username = user.getUsername();
            upassword = user.getUpassword();
        }else{
            System.out.println("登录失败！");
            success = false;
        }

        return success;
    }

    public void registration(User user) throws SQLException {


        int rows = 0;
        String sql = "insert into users(uname,udept,uclass,username,upassword,id,qnum) values(?,?,?,?,?,?,?)";
         if(user.getQnum()==0){
            String qnum = null;
            rows = executeUpdate(sql,user.getUname(),user.getUdept(),user.getUclass(),user.getUsername(),user.getUpassword(),user.getId(),qnum);
        }else{
        System.out.println(user.getUname());
        System.out.println(user.getUdept());
         rows = executeUpdate(sql,user.getUname(),user.getUdept(),user.getUclass(),user.getUsername(),user.getUpassword(),user.getId(),user.getQnum());
        }
        if(rows>0){
            System.out.println("注册成功！");
        }else{
            System.out.println("注册失败！");
        }

    }
//    public void registrationForTeacher(User user) throws SQLException {
//
//
//        int rows = 0;
//        String sql = "insert into users(uname,udept,uclass,username,upassword,id,qnum) values(?,?,?,?,?,?,?)";
//        if(user.getQnum()==0){
//            String qnum = null;
//            rows = executeUpdate(sql,user.getUname(),user.getUdept(),user.getUclass(),user.getUsername(),user.getUpassword(),user.getId(),qnum);
//        }else{
//            System.out.println(user.getUname());
//            System.out.println(user.getUdept());
//            rows = executeUpdate(sql,user.getUname(),user.getUdept(),user.getUclass(),user.getUsername(),user.getUpassword(),user.getId(),user.getQnum());
//        }
//        if(rows>0){
//            System.out.println("注册成功！");
//            username = user.getUsername();
//            upassword = user.getUpassword();
//        }else{
//            System.out.println("注册失败！");
//        }
//
//    }

    public void addCourse(Course course) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        boolean add =true;
        String sql = "select * from users where username=? and upassword=?";
        List<User> users = executeQuery(User.class, sql, username, upassword);
        User u1 = users.get(0);

        String sql1 = "insert into course(uno,cname) values(?,?)";
        int rows =  executeUpdate(sql1,u1.getUno(),course.getCname());
        if(rows>0) {

            String sql2 = "update users set qnum=?";
            int a = executeUpdate(sql2,u1.getQnum()+1);
            if(a>0)
                System.out.println("添加成功");
        }
        else
            System.out.println("添加失败!");
    }

    public String check() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


        String sql = "select id from users where username=? and upassword=?";
        List<User> users = executeQuery(User.class, sql, username, upassword);
        User u1 = users.get(0);
        return u1.getId();

    }

    public int checkQnum() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql = "select qnum from users where username=? and upassword=?";
        List<User> users = executeQuery(User.class, sql, username, upassword);
        User u1 = users.get(0);
        return u1.getQnum();

    }









}
