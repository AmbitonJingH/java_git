import Menu.loginAndRegistration;
import Dao.studentDao;
import Service.Service;
import Menu.useMenu;

import java.sql.SQLException;
import java.util.Scanner;

public class addtest {
    public static void main(String[] args) throws SQLException {
        test();
    }
    public static void test() throws SQLException {
        loginAndRegistration login = new loginAndRegistration();
        useMenu usemenu = new useMenu();
        login.loginandregistration();
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        switch (a){
            case 1:
                login.login();
                int a1 = input.nextInt();
                studentDao studentDao = new studentDao();
                Service service = new Service();
                switch (a1){
                    case 1:

                        break;
                    case 2:
                        service.loginStudent();
                        usemenu.userWelcome();
                        int a3 = input.nextInt();
                        switch (a3){
                            case 1:
                                usemenu.userSelect();
                                int a4 = input.nextInt();
                                switch (a4){
                                    case 1:break;
                                    case 2:
                                        studentDao.searchBook();break;
                                }
                                break;
                            case 2:break;
                            case 3:break;
                        }
                        break;
                }
                break;
            case 2:
                login.registration();
                int a2 = input.nextInt();
                studentDao studentDao1 = new studentDao();
                Service service1 = new Service();
                switch (a2){
                    case 1:
                        service1.zhuceTeacher();
                        System.out.println("注册成功！");
                        break;
                    case 2:
                        service1.zhuceStudent();
                        System.out.println("注册成功！");
                        break;
                }
                break;
        }
    }
}
