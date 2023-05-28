package Service;

import Model.Book;
import Model.Student;
import Dao.studentDao;
import Model.Teacher;
import Dao.teacherDao;
import Model.Users;
import Model.stuBorrow;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class Service {
    Scanner input = new Scanner(System.in);
    public void zhuceStudent() throws SQLException {

        Student student = new Student();
        studentDao studentDao = new studentDao();
        System.out.println("请输入用户名：");
        student.setUsername(input.next());
        System.out.println("请输入密码：");
        student.setPassword(input.next());
        System.out.println("请输入姓名：");
        student.setSname(input.next());
        System.out.println("请输入专业");
        student.setMajor(input.next());
        student.setNumOfBorrow(0);
        studentDao.zhuceStudent(student);

    }

    public void zhuceTeacher() throws SQLException {

        Teacher teacher = new Teacher();
        teacherDao teacherDao = new teacherDao();
        System.out.println("请输入用户名：");
        teacher.setUsername(input.next());
        System.out.println("请输入密码：");
        teacher.setPassword(input.next());
        System.out.println("请输入姓名：");
        teacher.setTname(input.next());
        System.out.println("请输入职称");
        teacher.setTitle(input.next());
        //teacherDao.zhuceTeacher(teacher);

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
        stuBorrow stuBorrow = new stuBorrow();
        studentDao studentDao = new studentDao();
        System.out.println("请输入要借阅的书籍号");
        stuBorrow.setBno(input.nextInt());
        studentDao.borrowBook(stuBorrow);

    }

    public void returnBook() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        stuBorrow stuBorrow = new stuBorrow();
        studentDao studentDao = new studentDao();
        System.out.println("请输入要归还的书籍号：");
        stuBorrow.setBno(input.nextInt());
        studentDao.returnBook(stuBorrow);
    }
    public void personBorrowRecode() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        stuBorrow stuBorrow = new stuBorrow();
        studentDao studentDao = new studentDao();
        studentDao.personBorrow(stuBorrow);
    }
}
