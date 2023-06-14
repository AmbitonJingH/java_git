package Dao;

import Model.Course;
import Model.Guidance;
import Model.Selection;
import Model.User;
import Utils.DaoUtil;
import Utils.JDBCUtil;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class SystemDao extends DaoUtil {

    private static String username;
    private static String upassword;
    private static String uno;

    public boolean login(User user) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        boolean success;

        String sql = "select * from user1 where username=? and upassword=?";
        List<User> users = executeQuery(User.class, sql, user.getUsername(), user.getUpassword());
        if(!users.isEmpty()){
            User user1 = users.get(0);
            System.out.println("登陆成功");
            success = true;
            username = user1.getUsername();
            upassword = user1.getUpassword();
            uno = user1.getUno();
        }else{
            System.out.println("登录失败！");
            success = false;
        }

        return success;
    }

    public void registration(User user) throws SQLException {


        int rows = 0;
        String sql = "insert into user1(uno,uname,usex,udept,uclass,username,upassword,id,offnum) values(?,?,?,?,?,?,?,?,?)";

        if(user.getUclass().equals("null")) {
            rows = executeUpdate(sql, user.getUno(), user.getUname(),user.getUsex(), user.getUdept(), user.getUclass(), user.getUsername(), user.getUpassword(), user.getId(), user.getOffnum());
            String sql1 = "update users set uclass = NULL where uno=?";
            executeUpdate(sql1,user.getUno());
        }else{
            rows = executeUpdate(sql, user.getUno(), user.getUname(),user.getUsex(), user.getUdept(), user.getUclass(), user.getUsername(), user.getUpassword(), user.getId(), user.getOffnum());

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
        String sql = "select * from user1 where username=? and upassword=?";
        List<User> users = executeQuery(User.class, sql, username, upassword);
        User u1 = users.get(0);

        String sql1 = "insert into course(tno,cname,member) values(?,?,?)";
        int rows =  executeUpdate(sql1,u1.getUno(),course.getCname(),course.getMemberNum());
        if(rows>0) {

            String sql2 = "update user1 set offnum=? where uno=?";
            int a = executeUpdate(sql2,u1.getOffnum()+1,u1.getUno());
            if(a>0)
                System.out.println("添加成功");
        }
        else
            System.out.println("添加失败!");
    }

    public String check() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


        String sql = "select id from user1 where username=? and upassword=?";
        List<User> users = executeQuery(User.class, sql, username, upassword);
        User u1 = users.get(0);
        return u1.getId();

    }

    public int checkOffnum() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql = "select offnum from user1 where username=? and upassword=?";
        List<User> users = executeQuery(User.class, sql, username, upassword);
        User u1 = users.get(0);
        return u1.getOffnum();

    }

    public void searchSelection() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql = "select * from sselect";
        List<Selection> selections = executeQuery(Selection.class, sql);

        //Selection s1 = selections.get(0);
        System.out.println(selections.toString());
    }

    public void searchCourse() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql = "select udept from user1 where uno = ?";
        List<User> users = executeQuery(User.class, sql, uno);
        User u1 = users.get(0);

        Connection connection = JDBCUtil.getConnection();
        String sql1 = "SELECT cno AS 题目号,uname AS 教师姓名,cname AS 题目名称 FROM course,user1 WHERE tno=uno AND udept=?";
        PreparedStatement statement = connection.prepareStatement(sql1);
        statement.setObject(1,u1.getUdept());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            String cno = resultSet.getString("题目号");
            String uname = resultSet.getString("教师姓名");
            String cname = resultSet.getString("题目名称");
            System.out.println("题目号:"+cno+"  教师姓名:"+uname+"  题目名称:"+cname);
        }
        resultSet.close();
        statement.close();
        JDBCUtil.freeConnection();

    }

    public void selectCourse(Course course) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


        Connection connection = JDBCUtil.getConnection();
        connection.setAutoCommit(false);
        int membernum = 0;
        String sql = "select * from course where cno=?";
        PreparedStatement statement2 = connection.prepareStatement(sql);
        statement2.setObject(1,course.getCno());
        ResultSet resultSet = statement2.executeQuery();
        while (resultSet.next()){
            membernum = resultSet.getInt("member");
        }

        String sql1 = "insert into sselect(cno,sno) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql1);
        statement.setObject(1,course.getCno());
        statement.setObject(2,uno);
        int rows = statement.executeUpdate();
        if(rows>0){

            try {
                String sql2 ="update course set member=? where cno=?";
                PreparedStatement statement1 = connection.prepareStatement(sql2);
                statement1.setObject(1,membernum+1);
                statement1.setObject(2,course.getCno());
                statement1.executeUpdate();
                connection.commit();
                System.out.println("选题成功！");
                statement1.close();

            } catch (SQLException e) {
                connection.rollback();
                System.out.println("选题失败！该课题人数已满！");
            }finally {
                resultSet.close();
                statement.close();
                statement2.close();
                JDBCUtil.freeConnection();
            }

        }


    }

    public void Submit(String address) throws SQLException, IOException {

        Connection connection = JDBCUtil.getConnection();

        File file = new File(address);
        FileInputStream fis = new FileInputStream(file);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len =-1;
        byte[] buf = new byte[1024];
        while ((len = fis.read(buf))!=-1){
            baos.write(buf,0,len);
        }
        baos.close();
        fis.close();
        byte[] bytes = baos.toByteArray();
        Blob blob = connection.createBlob();
        blob.setBytes(1,bytes);

        String sql ="update sselect set report =? where sno =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1,blob);
        statement.setObject(2,uno);
        int rows = statement.executeUpdate();
        statement.close();
        JDBCUtil.freeConnection();
        if(rows>0) {
            System.out.println("提交成功！");
            String sql1 = "update sselect set subtime =? where sno=?";
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            executeUpdate(sql1,timestamp,uno);
        }
        else
            System.out.println("提交失败！");

    }

    public void searchGrade() throws SQLException {

        Connection connection = JDBCUtil.getConnection();
        String sql = "select uname as 姓名,cname as 题目,grade as 成绩 from user1,course,sselect where sno=uno and sselect.cno=course.cno";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            String name = set.getString("姓名");
            String timu = set.getString("题目");
            float grade = set.getFloat("成绩");
            if(grade == 0.0)
                System.out.println("姓名:"+name+"  题目:"+timu+"  成绩:(未批改)");
            else
                System.out.println("姓名:"+name+"  题目:"+timu+"  成绩:"+grade);
        }
        set.close();
        statement.close();
        JDBCUtil.freeConnection();
    }

    public void viewRecords() throws SQLException {

        Connection connection = JDBCUtil.getConnection();
        String sql = "select sno as 学号,uname as 学生姓名,cname as 题目 from sselect,user1,course where sno=uno and tno=? and sselect.cno=course.cno";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1,uno);
        ResultSet resultSet = statement.executeQuery();
        System.out.println("=========================学生选题信息========================");
        while(resultSet.next()){

            String sno = resultSet.getString("学号");
            String uname = resultSet.getString("学生姓名");
            String timu = resultSet.getString("题目");
            System.out.println("学号:"+sno+"  学生姓名:"+uname+"  题目:"+timu);

        }
        System.out.println("==========================================================");
        resultSet.close();
        statement.close();
        JDBCUtil.freeConnection();


    }

    public void viewReport(String sno) throws SQLException, IOException {

        Connection connection = JDBCUtil.getConnection();
        String sql = "select report from sselect where sno=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1,sno);
        ResultSet set = statement.executeQuery();
        while (set.next()){

            Blob blob = set.getBlob("report");
            InputStream ips = blob.getBinaryStream();
            int len =-1;
            byte[] buf = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len = ips.read(buf))!=-1){
                baos.write(buf,0,len);
            }
            ips.close();
            baos.close();
            byte[] bytes = baos.toByteArray();
            System.out.println("请输入课程设计报告文件的下载路径：(例如：C:\\Users\\Lenovo\\Desktop\\ALL\\zuoye.doc)");
            Scanner sc = new Scanner(System.in);
            String address = sc.next();
            File file = new File(address);
            FileOutputStream fom = new FileOutputStream(file);
            fom.write(bytes);
            fom.close();

        }
    }

    public void guidance(String sno) throws SQLException, IOException {

        Connection connection = JDBCUtil.getConnection();
        Timestamp start = new Timestamp(System.currentTimeMillis());
        String sql = "select grade from sselect where sno=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1,sno);
        ResultSet set = statement.executeQuery();
        set.next();
        float grade = set.getFloat("grade");
        if(grade>=60.0)
            System.out.println("该学生课程设计已通过");
        else {
            viewReport(sno);
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的评语（不超过200字）：");
            String comment = sc.next();
            Timestamp end = new Timestamp(System.currentTimeMillis());
            String sql1 = "insert into guide(sno,tno,comments,starttime,endtime) values(?,?,?,?,?)";
            int rows = executeUpdate(sql1,sno,uno,comment,start,end);
            if(rows>0)
                System.out.println("评写成功");
            else
                System.out.println("评写失败");
        }

    }

    public void getComment() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql = "select comments from guide where sno = ? ";
        List<Guidance> guidances = executeQuery(Guidance.class, sql, uno);
        Guidance guidance = new Guidance();
        guidance = guidances.get(0);
        System.out.println(guidance.getComments());

    }
}
