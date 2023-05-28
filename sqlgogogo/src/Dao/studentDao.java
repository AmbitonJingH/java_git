package Dao;

import Model.*;
import Utils.BaseDao;
import Utils.JDBCUtil;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;

public class studentDao extends BaseDao {
    private static int sno;
    private static int tno;
    private static String username;
    private static String password;

    public void zhuceStudent(Student s) throws SQLException {

        String sql ="INSERT INTO student(sname,major,username,password,numofborrow)"+"VALUES("+"?,?,?,?,?)";
        String sql1 = "INSERT INTO users(username,password,id) VALUES(?,?,?)";
        int rows = executeUpdate(sql,s.getSname(),s.getMajor(),s.getUsername(),s.getPassword(),s.getNumOfBorrow());
        executeUpdate(sql1,s.getUsername(),s.getPassword(),"学生");
        if(rows>0){
            System.out.println("注册成功");
        }else{
            System.out.println("注册失败");
        }

    }

//    public void loginStudent(Student s) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//
//        String sql = "SELECT sno FROM users WHERE username=? AND PASSWORD=?;";
//        List<Student> students = executeQuery(Student.class, sql, s.getUsername(), s.getPassword());
//        sno = s.getSno();
//        if(!students.isEmpty()){
//            System.out.println("登陆成功");
//        }else{
//            System.out.println("登录失败");
//        }
//    }

    public void zhuceTeacher(Teacher t) throws SQLException {

        String sql ="INSERT INTO teacher(tname,title,username,password,numofborrow)"+"VALUES("+"?,?,?,?,?)";
        int rows = executeUpdate(sql,t.getTname(),t.getTitle(),t.getUsername(),t.getPassword(),t.getNumOfBorrow());
        String sql1 = "INSERT INTO users(username,password,id) VALUES(?,?,?)";
        executeUpdate(sql1,t.getUsername(),t.getPassword(),t.getTitle());
        if(rows>0){
            System.out.println("注册成功");
        }else{
            System.out.println("注册失败");
        }

    }

    public void login(Users user) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql = "SELECT * FROM users WHERE username=? AND PASSWORD=?;";
        List<Users> users = executeQuery(Users.class, sql, user.getUsername(), user.getPassword());
    //    tno = t.getTno();
        username = user.getUsername();
        password = user.getPassword();
        if(!users.isEmpty()){
            System.out.println("登陆成功");
        }else{
            System.out.println("登录失败");
        }
    }

    public void updateBook(Book book) throws SQLException {

        String sql = "insert into book(bno,bname,amount) values(?,?,?)";
        int rows = executeUpdate(sql,book.getBno(),book.getBname(),book.getAmount());
        if(rows>0){
            System.out.println("插入数据成功");
        }else{
            System.out.println("插入数据失败");
        }
    }
    public void searchBook() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql = "SELECT * FROM book;";
        List<Book> books =  executeQuery(Book.class,sql);

        System.out.println(books);

    }
    public void searchBookAsName(Book book) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql = "SELECT * FROM book where bname=?;";
        List<Book> books =  executeQuery(Book.class,sql,book.getBname());

        System.out.println(books);

    }

    public void borrowBook(stuBorrow stubook) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        boolean notnull = true;
        String sql1 = "select sno from student where username=? AND password=?;";
        List<Student> students = executeQuery(Student.class,sql1,username,password);
        Student s = students.get(0);
        sno = s.getSno();

        String sql6 = "select returnTime from stuborrow where sno=? and bno=?;";
        List<stuBorrow> stuBorrows = executeQuery(stuBorrow.class,sql6,sno,stubook.getBno());
        stuBorrow borrow = null;
        Date rdate = null;
        for(int i =0;i<stuBorrows.size();i++) {
            borrow = stuBorrows.get(i);
            rdate = borrow.getReturnTime();
            if(rdate==null)
                notnull = false;
        }
        if(notnull) {
            String sql = "INSERT INTO stuborrow(sno,bno,borrowTime) VALUES(?,?,?)";
            int rows = executeUpdate(sql, sno, stubook.getBno(), stubook.getBorrowTime());
            if (rows > 0) {

                String sql3 = "select numofborrow from student where sno =?;";
                List<Student> students1 = executeQuery(Student.class, sql3, sno);
                System.out.println(students1);
                Student s1 = students1.get(0);
                long numofborrow = s1.getNumOfBorrow();
                System.out.println(numofborrow);
                if (numofborrow < 6) {
                    System.out.println(sno);
                    String sql2 = "update student set numofborrow=? where sno=?;";
                    executeUpdate(sql2, numofborrow + 1, sno);

                    String sql5 = "select amount from book where bno =?;";
                    List<Book> books = executeQuery(Book.class, sql5, stubook.getBno());
                    Book book = books.get(0);
                    long amount = book.getAmount();

                    String sql4 = "update book set amount =? where bno =?;";
                    executeUpdate(sql4, amount - 1, stubook.getBno());
                    System.out.println("借阅成功");
                } else {
                    System.out.println("借阅次数已到达最大限度！！");
                }

            }
        }else{
            System.out.println("借阅失败");
        }
    }
    public void returnBook(stuBorrow temp) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Date date = new java.sql.Date(System.currentTimeMillis());

        String sql1 = "select sno from student where username=? AND password=?;";
        List<Student> students = executeQuery(Student.class,sql1,username,password);
        Student s = students.get(0);
        sno = s.getSno();

        String sql = "update stuborrow set returnTime=? where sno=? and bno=?;";
        int rows = executeUpdate(sql,date,sno,temp.getBno());

        if(rows>0){
            String sql3 = "select numofborrow from student where sno =?;";
            List<Student> students1 = executeQuery(Student.class,sql3,sno);
            System.out.println(students1);
            Student s1 = students1.get(0);
            long numofborrow = s1.getNumOfBorrow();
            System.out.println(numofborrow);
            if(numofborrow<6) {
                System.out.println(sno);
                String sql2 = "update student set numofborrow=? where sno=?;";
                executeUpdate(sql2, numofborrow-1, sno);

                String sql5 = "select amount from book where bno =?;";
                List<Book> books = executeQuery(Book.class, sql5, temp.getBno());
                Book book = books.get(0);
                long amount = book.getAmount();

                String sql4 = "update book set amount =? where bno =?;";
                executeUpdate(sql4, amount + 1, temp.getBno());
                System.out.println("归还成功");
            }


        }else{
            System.out.println("归还失败");
        }

    }

    public void personBorrow(stuBorrow stuBorrow) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql1 = "select sno from student where username=? AND password=?;";
        List<Student> students = executeQuery(Student.class,sql1,username,password);
        Student s = students.get(0);
        sno = s.getSno();
        System.out.println(sno);
        String sql = "select * from stuborrow where sno=?;";
        List<stuBorrow> stuBorrows = executeQuery(stuBorrow.class,sql,sno);
        System.out.println(stuBorrows);
    }
 //   @Test
//    public void test() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        stuBorrow stuBorrow = new stuBorrow();
//        Date date = new java.sql.Date(System.currentTimeMillis());
//        stuBorrow.setBno(1);
//        stuBorrow.setBorrowTime(date);
//        username="159634";
//        password="333";
//        borrowBook(stuBorrow);
//    }
//    @Test
//    public void test1() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        String sql = "select * from student;";
//        List<Student> students = executeQuery(Student.class,sql);
//        System.out.println(students);
//
//    }


}
