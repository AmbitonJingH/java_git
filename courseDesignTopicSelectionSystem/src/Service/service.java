package Service;

import Dao.SystemDao;
import Model.Course;
import Model.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class service {
    Scanner input = new Scanner(System.in);

    public boolean login() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        User user = new User();
        SystemDao systemDao = new SystemDao();
        System.out.println("请输入用户名：");
        user.setUsername(input.next());
        System.out.println("请输入密码：");
        user.setUpassword(input.next());
        boolean login = systemDao.login(user);

        return login;

    }

    public void registrationForStudent() throws SQLException {

        User user = new User();
        SystemDao systemDao = new SystemDao();
        System.out.println("请输入用户名：");
        user.setUsername(input.next());
        System.out.println("请输入密码：");
        user.setUpassword(input.next());
        System.out.println("请再次输入密码：");
        String checkPassword = input.next();
        if(checkPassword.equals(user.getUpassword())){

            System.out.println("请输入姓名：");
            user.setUname(input.next());
            System.out.println("请输入院系：");
            user.setUdept(input.next());
            System.out.println("请输入班级：");
            user.setUclass(input.next());
            user.setId("学生");
            System.out.println(user);
            systemDao.registration(user);

        }else{
            System.out.println("两次密码输入不一致！");
            registrationForStudent();
        }

    }

    public void registrationForTeacher() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        User user = new User();
        SystemDao systemDao = new SystemDao();
        System.out.println("请输入用户名：");
        user.setUsername(input.next());
        System.out.println("请输入密码：");
        user.setUpassword(input.next());
        System.out.println("请再次输入密码：");
        String checkPassword = input.next();
        if(checkPassword.equals(user.getUpassword())){

            System.out.println("请输入姓名：");
            user.setUname(input.next());
            System.out.println("请输入院系：");
            user.setUdept(input.next());
            user.setUclass("null");
            user.setId("教师");
        //    user.setQnum(3);
            systemDao.registration(user);
//            System.out.println("请添加3个课程设计题目：");
//            for(int i=0;i<3;i++){
//                Course course = new Course();
//                System.out.println("请输入课程设计题目：");
//                course.setCname(input.next());
//                course.setUno(user.getUno());
//                systemDao.addCourse(course);
//            }

        }else{
            System.out.println("两次密码输入不一致！");
            registrationForStudent();
        }

    }

    public void addCourse() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        boolean add = true;
        SystemDao systemDao = new SystemDao();
        int num = systemDao.checkQnum();

            while (add) {

                if(num==0) {
                    System.out.println("第一次添加题目最少添加3个，最多添加6个");
                    for (int i = 0; i < 3; i++) {

                        Course course = new Course();
                        System.out.println("请输入要添加的题目：");
                        course.setCname(input.next());
                        systemDao.addCourse(course);

                    }
                }else {
                    Course course = new Course();
                    System.out.println("请输入要添加的题目：");
                    course.setCname(input.next());
                    systemDao.addCourse(course);
                }
                    System.out.println("是否继续添加？(y/n)");
                    String flag = input.next();
                    if (flag.equals("n"))
                        add = false;

            }

    }
    public String check() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        SystemDao systemDao = new SystemDao();
        return systemDao.check();

    }









}
