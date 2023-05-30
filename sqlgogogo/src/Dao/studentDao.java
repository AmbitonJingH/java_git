package Dao;

import Model.*;
import Utils.BaseDao;
import Utils.JDBCUtil;
import com.mysql.cj.util.StringUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;

public class studentDao extends BaseDao {
    private static int uno;
    private static String username;
    private static String password;

    public void zhuceStudent(Users u) throws SQLException {

        String sql ="INSERT INTO users(uname,major,username,password,numofborrow,id)"+"VALUES("+"?,?,?,?,?,?)";

        int rows = executeUpdate(sql,u.getUname(),u.getMajor(),u.getUsername(),u.getPassword(),u.getNumofborrow(),u.getId());
        //executeUpdate(sql1,s.getUsername(),s.getPassword(),"学生");
        if(rows>0){
            System.out.println("注册成功");
        }else{
            System.out.println("注册失败");
        }

    }


    public void zhuceTeacher(Users u) throws SQLException {

        String sql ="INSERT INTO users(uname,major,username,password,numofborrow,id)"+"VALUES("+"?,?,?,?,?,?)";

        int rows = executeUpdate(sql,u.getUname(),u.getMajor(),u.getUsername(),u.getPassword(),u.getNumofborrow(),u.getId());
        //executeUpdate(sql1,s.getUsername(),s.getPassword(),"学生");
        if(rows>0){
            System.out.println("注册成功");
        }else{
            System.out.println("注册失败");
        }

    }

    public String login(Users user) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql = "SELECT * FROM users WHERE binary username=? AND PASSWORD=?;";
        String loginSituatio;
        List<Users> users = executeQuery(Users.class, sql, user.getUsername(), user.getPassword());
    //    tno = t.getTno();
        username = user.getUsername();
        password = user.getPassword();
        if(!users.isEmpty()){
            loginSituatio = "登陆成功";
            System.out.println(loginSituatio);
        }else{
            loginSituatio = "登录失败";
            System.out.println(loginSituatio);
        }
        return loginSituatio;
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

    public void borrowBook(Borrow stubook) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Connection connection = JDBCUtil.getConnection();
        boolean notnull = true;
        int setnum;
        if(check().equals("学生")){
            setnum=5;
        }else if(check().equals("助教")){
            setnum=6;
        }else if(check().equals("讲师")){
            setnum=8;
        }else{
            setnum=10;
        }
        try {
            connection.setAutoCommit(false);
            String sql1 = "select uno from users where username=? AND password=?;";
            List<Users> users = executeQuery(Users.class, sql1, username, password);
            Users s = users.get(0);
            uno = s.getUno();

            String sql6 = "select returnTime from borrow where uno=? and bno=?;";
            List<Borrow> Borrows = executeQuery(Borrow.class, sql6, uno, stubook.getBno());
            Borrow borrow = null;
            Date rdate = null;
            for (int i = 0; i < Borrows.size(); i++) {
                borrow = Borrows.get(i);
                rdate = borrow.getReturnTime();
                if (rdate == null)
                    notnull = false;
            }
            if (notnull) {
                String sql = "INSERT INTO borrow(uno,bno,borrowTime) VALUES(?,?,?)";
                int rows = executeUpdate(sql, uno, stubook.getBno(), stubook.getBorrowTime());
                if (rows > 0) {

                    String sql3 = "select numofborrow from users where uno =?;";
                    List<Users> students1 = executeQuery(Users.class, sql3, uno);
                    //System.out.println(students1);
                    Users s1 = students1.get(0);
                    long numofborrow = s1.getNumofborrow();
                   // System.out.println(numofborrow);
                    if (numofborrow < setnum) {
                        System.out.println(uno);
                        String sql2 = "update users set numofborrow=? where uno=?;";
                        executeUpdate(sql2, numofborrow + 1, uno);

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
            }
            connection.commit();

        }catch (Exception e){

            connection.rollback();
            System.out.println("借阅失败");

        }
    }
    public void returnBook(Borrow temp) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Date date = new java.sql.Date(System.currentTimeMillis());

        String sql1 = "select uno from users where username=? AND password=?;";
        List<Users> students = executeQuery(Users.class,sql1,username,password);
        Users s = students.get(0);
        uno = s.getUno();

        String sql = "update borrow set returnTime=? where uno=? and bno=?;";
        int rows = executeUpdate(sql,date,uno,temp.getBno());

        if(rows>0){
            String sql3 = "select numofborrow from users where uno =?;";
            List<Student> students1 = executeQuery(Student.class,sql3,uno);
            System.out.println(students1);
            Student s1 = students1.get(0);
            long numofborrow = s1.getNumOfBorrow();
            System.out.println(numofborrow);
            if(numofborrow<5) {
                System.out.println(uno);
                String sql2 = "update users set numofborrow=? where uno=?;";
                executeUpdate(sql2, numofborrow-1, uno);

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

    public void personBorrow(Borrow Borrow) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql1 = "select uno from users where username=? AND password=?;";
        List<Users> students = executeQuery(Users.class,sql1,username,password);
        Users s = students.get(0);
        uno = s.getUno();
        System.out.println(uno);
        String sql = "select * from borrow where uno=?;";
        List<Borrow> Borrows = executeQuery(Borrow.class,sql,uno);
        System.out.println(Borrows);
    }

    public void adminBorrow(Borrow Borrow) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql = "select * from borrow;";
        List<Borrow> Borrows = executeQuery(Borrow.class,sql);
        System.out.println("\t----------------------------全部借阅记录---------------------------------\n");
        System.out.println(Borrows.toString().replaceAll(",", "").replace("[","").replace("]",""));
        System.out.println("\t-----------------------------------------------------------------------");
    }

    public String check() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql = "select id from users where username=? and password=?";
        List<Users> students = executeQuery(Users.class,sql,username,password);
        Users s = students.get(0);
        String id = s.getId();
        //System.out.println(id);
        return id;

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
