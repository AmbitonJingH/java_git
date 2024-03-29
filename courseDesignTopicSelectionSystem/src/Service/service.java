package Service;

import Dao.SystemDao;
import Model.Course;
import Model.Department;
import Model.User;
import Utils.FanProblem;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class service {
    Scanner input = new Scanner(System.in);
    SystemDao systemDao = new SystemDao();
    FanProblem fan = new FanProblem();
    public boolean login() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        User user = new User();
        SystemDao systemDao = new SystemDao();
        System.out.println("请输入用户名：");
        user.setUsername(input.next());
        System.out.println("请输入密码：");
        user.setUpassword(input.next());

        return systemDao.login(user);

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

            System.out.println("请输入学号：");
            user.setUno(input.next());
            System.out.println("请输入姓名：");
            user.setUname(input.next());
            System.out.println("请输入性别：");
            user.setUsex(input.next());
            System.out.println("可选院系：");
            System.out.println("---------------------------------------学院汇总------------------------------------------");
            int j = 0;
            for (Department i:Department.values()) {
                System.out.print(i.getName()+" ");
                j++;
                if(j%7==0)
                    System.out.println();
            }
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("请输入院系：");
            String temp;
            boolean a = true;
            while (a) {
                temp = input.next();
                for (Department i:Department.values()) {
                    if(temp.equals(i.getName())){
                        user.setUdept(temp);
                        a = false;
                        break;
                    }
                }
                if(a)
                    System.out.println("输入错误，请重新输入:");
            }

            System.out.println("请输入班级：");
            user.setUclass(input.next());
            user.setId("学生");
            //System.out.println(user);
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

            System.out.println("请输入教师号：");
            user.setUno(input.next());
            System.out.println("请输入姓名：");
            user.setUname(input.next());
            System.out.println("请输入性别：");
            user.setUsex(input.next());
            System.out.println("可选院系：");
            System.out.println("---------------------------------------学院汇总------------------------------------------");
            int j = 0;
            for (Department i:Department.values()) {
                System.out.print(i.getName()+" ");
                j++;
                if(j%7==0)
                    System.out.println();
            }
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("请输入院系：");
            String temp;
            boolean a = true;
            while (a) {
                temp = input.next();
                for (Department i:Department.values()) {
                    if(temp.equals(i.getName())){
                        user.setUdept(temp);
                        a = false;
                        break;
                    }
                }
                if(a)
                    System.out.println("输入错误，请重新输入:");
            }
            user.setUclass("null");
            user.setId("教师");
        //    user.setQnum(3);
            systemDao.registration(user);
        }else{
            System.out.println("两次密码输入不一致！");
            registrationForTeacher();
        }

    }

    public void addCourse() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        boolean add = true;
        SystemDao systemDao = new SystemDao();
        //int num = systemDao.checkOffnum();

            while (add) {

                if(systemDao.checkOffnum()==0) {
                    System.out.println("第一次添加题目最少添加3个，最多添加6个");
                    for (int i = 0; i < 3; i++) {

                        Course course = new Course();
                        System.out.println("请输入要添加的题目：");
                        course.setCname(input.next());
                        systemDao.addCourse(course);

                    }
                }else if(systemDao.checkOffnum()==6){
                    System.out.println("添加题目数量已上限！！！！");
                    break;
                } else {
                    Course course = new Course();
                    System.out.println("请输入要添加的题目：");
                    course.setCname(input.next());
                    systemDao.addCourse(course);
                }
                boolean temp = true;
                while (temp) {
                    System.out.println("是否继续添加？(y/n)");
                    String flag = input.next();
                    if (flag.equals("n")) {
                        add = false;
                        temp = false;
                    }else if(flag.equals("y")){
                        temp = false;
                    }else {
                        System.out.println("输入错误！");
                    }
                }


            }

    }
    public String check() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        SystemDao systemDao = new SystemDao();
        return systemDao.check();

    }

    public void searchSelection() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SystemDao systemDao = new SystemDao();
        systemDao.searchAllSelection();
    }

    public void searchCourse() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        SystemDao systemDao = new SystemDao();
        systemDao.searchCourse();

    }

    public void selectCourse() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        SystemDao systemDao = new SystemDao();
        Course course = new Course();
        System.out.println("请输入你要选择的题目的序号：");
        course.setCno(fan.woChaoFan());
        systemDao.selectCourse(course);
    }

    public void Submit() throws SQLException, IOException {

        SystemDao systemDao = new SystemDao();
        System.out.println("请输入您的实验报告所在路径：");
        System.out.println("例如：C:\\Users\\Lenovo\\Desktop\\ALL\\zuoye.doc");
        String file  = input.next();
        systemDao.Submit(file);

    }

    public void getGrade() throws SQLException {

        systemDao.searchGrade();

    }

    public void viewRecords() throws SQLException {

        systemDao.viewRecords();
    }

    public String viewReport() throws SQLException, IOException {

        viewRecords();
        System.out.println("请输入要查看课程设计报告的学生学号：");
        String sno = input.next();
        System.out.println("请输入课程设计报告文件的下载路径：(例如：C:\\Users\\Lenovo\\Desktop\\ALL\\zuoye.doc)");
        String address = input.next();
        return systemDao.viewReport(sno,address);

    }

    public void guidance(String sno) throws SQLException, IOException {

        systemDao.guidance(sno);

    }

    public void getComment() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        systemDao.getComment();
    }

    public void showAllUsers() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        systemDao.showAllUsers();
    }

    public void deleteRecord() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("请输入要删除选题信息的学生学号：");
        String sno = input.next();
        systemDao.deleteRecord(sno);
    }

    public void Grade(String sno){
        System.out.println("请输入该学生的分数(若不评分请输入“退出”):");
        while (true) {
            try {
                String temp = input.next();
                float grade=0;
                if(temp.equals("退出"))
                    return;
                else {
                    grade = Float.parseFloat(temp);
                    systemDao.grade(grade,sno);
                    break;
                }
            } catch (NumberFormatException | SQLException e) {
                System.out.println("输入错误，请重新输入:");
            }
        }
    }

    public void viewMyRecord() throws SQLException {
        systemDao.viewMyRecord();

    }

    public void deleteCourse() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("请输入要删除的题目的题目号:");
        int cno = fan.woChaoFan();
        systemDao.deleteCourse(cno);
    }

}
