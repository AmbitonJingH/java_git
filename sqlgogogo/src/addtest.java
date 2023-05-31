import Menu.AdminMenu;
import Menu.loginAndRegistration;
import Dao.studentDao;
import Service.Service;
import Menu.useMenu;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class addtest {
    public static void main(String[] args) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        test();
    }
    public static void test() throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        loginAndRegistration login = new loginAndRegistration();
        useMenu usemenu = new useMenu();
        Scanner input = new Scanner(System.in);
        studentDao studentDaod = new studentDao();
        boolean isloginandregistrationOpen = true;
        boolean isusewelcome = true;
        boolean isuseselect = true;
        while (isloginandregistrationOpen){
        login.loginandregistration();
        int a = input.nextInt();
        switch (a){
            case 0:
                isloginandregistrationOpen = false;
                break;
            case 1:

                studentDao studentDao = new studentDao();
                Service service = new Service();
                String loginSituation = service.loginStudent();
                    if(loginSituation.equals("登陆成功")) {
                        String check = studentDao.check();
                        while (isusewelcome) {
                            if (!check.equals("管理员")) {

                                usemenu.userWelcome();
                                int a3 = input.nextInt();
                                switch (a3) {
                                    case 0:
                                        isusewelcome = false;
                                        break;
                                    case 1:
                                        while (isuseselect) {

                                            usemenu.userSelect();
                                            int a4 = input.nextInt();
                                            switch (a4) {
                                                case 0:
                                                    isuseselect = false;
                                                    break;
                                                case 1:
                                                    service.searchBookAsName();
                                                    break;
                                                case 2:
                                                    service.allBook();
                                                    break;
                                            }
                                        }
                                        break;
                                    case 2:
                                        service.borrowBook();
                                        break;
                                    case 3:
                                        service.returnBook();
                                        break;
                                    case 4:
                                        service.personBorrowRecode();
                                        break;
                                }
                               // break;
                            } else {
                                AdminMenu adminMenu = new AdminMenu();
                                adminMenu.firstMenu();
                                int admi;
                                //System.out.println("请输入要进行的操作：");
                                admi = input.nextInt();
                                switch (admi) {
                                    case 0:
                                        isusewelcome = false;
                                        break;
                                    case 1:
                                        service.allBook();
                                        break;
                                    case 2:
                                        service.addBook();
                                        break;
                                    case 3:
                                        service.adminBorrowRecode();
                                        break;
                                }
                            }
                        }
                    }else{
                        break;
                    }
              //  }
                break;
            case 2:
                login.registration();
                int a2 = input.nextInt();
                studentDao studentDao1 = new studentDao();
                Service service1 = new Service();
                switch (a2){
                    case 1:
                        service1.zhuceTeacher();
                       // System.out.println("注册成功！");
                        break;
                    case 2:
                        service1.zhuceStudent();
                       // System.out.println("注册成功！");
                        break;
                }
                break;
        }
    }
}
}
