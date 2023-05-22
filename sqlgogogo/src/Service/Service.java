package Service;

import Model.Student;
import Dao.studentDao;

import java.sql.SQLException;
import java.util.Scanner;

public class Service {
    public void zhuceStudent() throws SQLException {
        Scanner input = new Scanner(System.in);
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
}
