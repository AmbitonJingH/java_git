import Menu.loginAndRegistration;
import Dao.studentDao;
import Service.Service;

import java.sql.SQLException;
import java.util.Scanner;

public class addtest {
    public static void main(String[] args) throws SQLException {
        test();
    }
    public static void test() throws SQLException {
        loginAndRegistration login = new loginAndRegistration();
        login.loginandregistration();
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        switch (a){
            case 1:
                login.login();
//                int b = input.nextInt();
//                studentDao studentDao = new studentDao();
//                Service service = new Service();
//                switch (b){
//                    case 1:
//                        break;
//                    case 2:
//                        service.zhuceStudent();
//                        System.out.println("注册成功！");
//                        break;
//                }
                break;
            case 2:
                login.registration();
                int c = input.nextInt();
                studentDao studentDao = new studentDao();
                Service service = new Service();
                switch (c){
                    case 1:
                        break;
                    case 2:
                        service.zhuceStudent();
                        System.out.println("注册成功！");
                        break;
                }
                break;
        }
    }
}
