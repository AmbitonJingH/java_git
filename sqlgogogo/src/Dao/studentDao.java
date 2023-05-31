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

        try {
            String sql ="INSERT INTO users(uname,major,username,password,numofborrow,id)"+"VALUES("+"?,?,?,?,?,?)";

            int rows = executeUpdate(sql,u.getUname(),u.getMajor(),u.getUsername(),u.getPassword(),u.getNumofborrow(),u.getId());
            //executeUpdate(sql1,s.getUsername(),s.getPassword(),"学生");
            if(rows>0){
                System.out.println("注册成功");
            }else{
                System.out.println("注册失败");
            }
        } catch (Exception e) {
            System.out.println("注册失败，用户名已存在！");
        }

    }


    public void zhuceTeacher(Users u) throws SQLException {

        try {
            String sql ="INSERT INTO users(uname,major,username,password,numofborrow,id)"+"VALUES("+"?,?,?,?,?,?)";

            int rows = executeUpdate(sql,u.getUname(),u.getMajor(),u.getUsername(),u.getPassword(),u.getNumofborrow(),u.getId());
            //executeUpdate(sql1,s.getUsername(),s.getPassword(),"学生");
            if(rows>0){
                System.out.println("注册成功");
            }else{
                System.out.println("注册失败");
            }
        } catch (Exception e) {
            System.out.println("注册失败，用户名已存在！");
        }

    }

    public String login(Users user) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql = "SELECT * FROM users WHERE binary username=? AND PASSWORD=?";
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

        String sql = "SELECT * FROM book";
        List<Book> books =  executeQuery(Book.class,sql);

        System.out.println(books);

    }
    public void searchBookAsName(Book book) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql = "SELECT * FROM book where bname=?";
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
            String sql1 = "select uno from users where username=? AND password=?";
            List<Users> users = executeQuery1(Users.class, sql1, username, password);
            Users s = users.get(0);
            uno = s.getUno();

            String sql6 = "select returnTime from borrow where uno=? and bno=?";
            List<Borrow> Borrows = executeQuery1(Borrow.class, sql6, uno, stubook.getBno());
            Borrow borrow = null;
            Timestamp temp = null;
            for (int i = 0; i < Borrows.size(); i++) {
                borrow = Borrows.get(i);
                temp = borrow.getReturnTime();
                if (temp == null)
                    notnull = false;
            }
            if (notnull) {

                    String sql = "INSERT INTO borrow(uno,bno,borrowTime) VALUES(?,?,?)";
                    int rows = executeUpdate1(sql, uno, stubook.getBno(), stubook.getBorrowTime());
                    if (rows > 0) {

                        String sql3 = "select numofborrow from users where uno =?";
                        List<Users> students1 = executeQuery1(Users.class, sql3, uno);

                        Users s1 = students1.get(0);
                        long numofborrow = s1.getNumofborrow();

                        if (numofborrow < setnum) {
                            System.out.println(uno);
                            String sql2 = "update users set numofborrow=? where uno=?";
                            executeUpdate1(sql2, numofborrow + 1, uno);

                            String sql5 = "select amount from book where bno =?";
                            List<Book> books = executeQuery1(Book.class, sql5, stubook.getBno());
                            Book book = books.get(0);
                            long amount = book.getAmount();

                            String sql4 = "update book set amount =? where bno =?";
                            executeUpdate1(sql4, amount - 1, stubook.getBno());
                            System.out.println("借阅成功");
                            Connection connection1 = JDBCUtil.getConnection();
                            connection1.commit();
                           // connection1.commit();
                            //connection.close();
                        } else {
                            System.out.println("借阅次数已到达最大限度！！");
                            Connection connection1 = JDBCUtil.getConnection();
                            connection1.setAutoCommit(false);
                            connection1.rollback();
                        }
                    }
                }else{
                System.out.println("这本书你还未归还！");
            }
        } catch (Exception e) {
           // connection.setAutoCommit(false);
            Connection connection1 = JDBCUtil.getConnection();
            connection1.rollback();
            System.out.println("借阅失败");
            //connection.setAutoCommit(true);
           // connection.close();
            //e.printStackTrace();
        }

    }
//    @Test
//    public void test() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        String sql1 = "select uno from users where username=? AND password=?";
//        List<Users> users = executeQuery(Users.class, sql1, username, password);
//        Users s = users.get(0);
//        uno = s.getUno();
//    }
    public void returnBook(Borrow temp) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Timestamp date = new Timestamp(System.currentTimeMillis());
        Connection connection = JDBCUtil.getConnection();

//        int setNum;
//        String
        String sql1 = "select uno from users where username=? AND password=?;";
        List<Users> students = executeQuery1(Users.class,sql1,username,password);
        Users s = students.get(0);
        uno = s.getUno();
      //  System.out.println("1");
//        String sql6 = "select returnTime from borrow where uno=? and bno=?";
//        List<Borrow> borrows = executeQuery(Borrow.class,sql6,uno,temp.getBno());
//        Borrow b = borrows.get(0);
//        Date d = b.getReturnTime();
//        if(d==null) {
       // try {
            String sql = "update borrow set returnTime=? where uno=? and bno=? and returnTime is null";
            int rows = executeUpdate1(sql, date, uno, temp.getBno());
            //System.out.println(rows);

            if (rows > 0) {
                String sql3 = "select numofborrow from users where uno =?;";
                List<Users> students1 = executeQuery1(Users.class, sql3, uno);

                Users s1 = students1.get(0);
                long numofborrow = s1.getNumofborrow();
                if (numofborrow > 0) {
                    //System.out.println(uno);
                    String sql2 = "update users set numofborrow=? where uno=?;";
                    executeUpdate1(sql2, numofborrow - 1, uno);

                    String sql5 = "select amount from book where bno =?;";
                    List<Book> books = executeQuery1(Book.class, sql5, temp.getBno());
                    Book book = books.get(0);
                    long amount = book.getAmount();

                    String sql4 = "update book set amount =? where bno =?;";
                    executeUpdate1(sql4, amount + 1, temp.getBno());
                    connection.commit();
                    System.out.println("归还成功");
                }else {
                    System.out.println("归还失败");
                }
            } else {
                System.out.println("归还失败,无可归还的书籍！");
            }
//        } catch (Exception e) {
//            connection.rollback();
//            System.out.println("归还失败");
//            e.printStackTrace();
//        }
//        }else{
//            System.out.println("这本书已归还");
//        }

    }

    public void personBorrow(Borrow Borrow) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String sql1 = "select uno from users where username=? AND password=?;";
        List<Users> students = executeQuery(Users.class,sql1,username,password);
        Users s = students.get(0);
        uno = s.getUno();
       // System.out.println(uno);
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

    public void addBook(Book book) throws SQLException {

        try {
            String sql ="insert into book(bno,bname,amount) values(?,?,?)";
            int rows = executeUpdate(sql,book.getBno(),book.getBname(),book.getAmount());
            if(rows>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (Exception e) {
            System.out.println("添加失败，该书已存在！");
        }

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
