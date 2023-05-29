package Service;

import Model.Book;
import Dao.studentDao;
import Model.Teacher;
import Dao.teacherDao;
import Model.Users;
import Model.Borrow;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class Service {
    Scanner input = new Scanner(System.in);
    public void zhuceStudent() throws SQLException {

        Users users = new Users();
        studentDao studentDao = new studentDao();
        System.out.println("请输入用户名：");
        users.setUsername(input.next());
        System.out.println("请输入密码：");
        users.setPassword(input.next());
        System.out.println("请输入姓名：");
        users.setUname(input.next());
        System.out.println("请输入专业");
        users.setMajor(input.next());
        users.setNumofborrow(0);
        users.setId("学生");
        studentDao.zhuceStudent(users);

    }

    public void zhuceTeacher() throws SQLException {

        Users users = new Users();
        studentDao studentDao = new studentDao();
        System.out.println("请输入用户名：");
        users.setUsername(input.next());
        System.out.println("请输入密码：");
        users.setPassword(input.next());
        System.out.println("请输入姓名：");
        users.setUname(input.next());
        System.out.println("请输入所属专业：");
        users.setMajor(input.next());
        users.setNumofborrow(0);
        System.out.println("请输入职称：");
        users.setId(input.next());
        studentDao.zhuceTeacher(users);

    }

    public void loginStudent() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Users student = new Users();
        studentDao studentDao = new studentDao();
        System.out.println("请输入用户名：");
        student.setUsername(input.next());
        System.out.println("请输入密码：");
        student.setPassword(input.next());
        studentDao.login(student);

    }

    public void loginTeacher() throws SQLException {

        Teacher teacher = new Teacher();
        teacherDao teacherDao = new teacherDao();
        System.out.println("请输入用户名：");
        teacher.setUsername(input.next());
        System.out.println("请输入密码：");
        teacher.setPassword(input.next());

        //teacherDao.loginTeacher(teacher);
    }

    public void addBook(){

        studentDao studentDao = new studentDao();
        Book b = new Book();
        System.out.println("请输入书籍名称：");
        b.setBname(input.next());
        System.out.println("请输入数量：");
        b.setAmount(input.nextInt());


    }

    public void allBook() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        studentDao studentDao = new studentDao();

        studentDao.searchBook();
    }

    public void searchBookAsName() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Book book = new Book();
        studentDao studentDao = new studentDao();
        System.out.println("请输入要查询的书籍的书名：");
        book.setBname(input.next());

        studentDao.searchBookAsName(book);
    }

    public void borrowBook() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

            Borrow Borrow = new Borrow();
            studentDao studentDao = new studentDao();
            System.out.println("请输入要借阅的书籍号");
            Borrow.setBno(input.nextInt());
            studentDao.borrowBook(Borrow);

    }

    public void returnBook() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Borrow Borrow = new Borrow();
        studentDao studentDao = new studentDao();
        System.out.println("请输入要归还的书籍号：");
        Borrow.setBno(input.nextInt());
        studentDao.returnBook(Borrow);
    }

    public void personBorrowRecode() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Borrow Borrow = new Borrow();
        studentDao studentDao = new studentDao();
        studentDao.personBorrow(Borrow);
    }

    public void adminBorrowRecode() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Borrow Borrow = new Borrow();
        studentDao studentDao = new studentDao();
        studentDao.adminBorrow(Borrow);

    }
}
