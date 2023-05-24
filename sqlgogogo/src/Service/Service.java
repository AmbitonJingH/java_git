package Service;

import Model.Student;
import Dao.studentDao;
import Model.Teacher;
import Dao.teacherDao;
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
        System.out.println("请输入学号：");
        student.setSno(input.next());
        System.out.println("请输入姓名：");
        student.setSname(input.next());
        System.out.println("请输入专业");
        student.setMajor(input.next());
        studentDao.zhuceStudent(student);
    }
    public void zhuceTeacher() throws SQLException {
        Teacher teacher = new Teacher();
        teacherDao teacherDao = new teacherDao();
        System.out.println("请输入用户名：");
        teacher.setUsername(input.next());
        System.out.println("请输入密码：");
        teacher.setPassword(input.next());
        System.out.println("请输入教师号：");
        teacher.setTno(input.next());
        System.out.println("请输入姓名：");
        teacher.setTname(input.next());
        System.out.println("请输入职称");
        teacher.setTitle(input.next());
        teacherDao.zhuceTeacher(teacher);
    }
    public void loginStudent() throws SQLException {
        Student student = new Student();
        studentDao studentDao = new studentDao();
        System.out.println("请输入用户名：");
        student.setUsername(input.next());
        System.out.println("请输入密码：");
        student.setPassword(input.next());
        studentDao.loginStudent(student);

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
    public void allBook(){

    }

}
