package controller;

import Menu.*;
import Service.service;
import Utils.FanProblem;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class controllerService {

    public static void main(String[] args) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        loginAndRegistration loginAndRegistration = new loginAndRegistration();
        userMenu userMenu = new userMenu();
        service service = new service();
        Scanner input = new Scanner(System.in);
        boolean loginAndRegistrationIsOpen = true;
        FanProblem f = new FanProblem();

        while (loginAndRegistrationIsOpen) {

            boolean registrationIsOpen = true;
            boolean menuForUser = true;
            boolean ReportOperationIsOpen = true;

            loginAndRegistration.loginAndRegistration();
//            int a1 = 0;
//            while (true) {
//                String str = input.next();
//                try {
//                    a1 = f.woChaoFan();
//                    //a1 = Integer.parseInt(str);
//                    break;
//                } catch (Exception e) {
//                    System.out.println("输入错误,请重新输入：");
//                }
//            }
            int a1 = f.woChaoFan();
            switch (a1) {
                case 0:
                    loginAndRegistrationIsOpen = false;
                    break;
                case 1:
                    if (service.login()) {
                        if (service.check().equals("学生")) {
                            while (menuForUser) {
                                userMenu.forStudent();
                                int a2 = f.woChaoFan();
                                switch (a2) {
                                    case 0:
                                        menuForUser = false;
                                        break;
                                    case 1:
                                        service.searchCourse();
                                        break;
                                    case 2:
                                        service.selectCourse();
                                        break;
                                    case 3:
                                        service.Submit();
                                        break;
                                    case 4:
                                        service.getComment();
                                        break;
                                    case 5:
                                        service.getGrade();
                                        break;
                                }
                            }
                        } else if (service.check().equals("教师")) {
                            while (menuForUser) {
                                userMenu.forTeacher();
                                int a2 = f.woChaoFan();
                                switch (a2) {
                                    case 0:
                                        menuForUser = false;
                                        break;
                                    case 1:
                                        service.addCourse();
                                        break;
                                    case 2:
                                        service.deleteCourse();
                                        break;
                                    case 3:
                                        service.viewMyRecord();
                                        break;
                                    case 4:
                                        service.viewRecords();
                                        break;
                                    case 5:
                                        String sno = service.viewReport();
                                        if (!sno.equals("false")) {
                                            while (ReportOperationIsOpen) {
                                                userMenu.ReportOperation();
                                                int a3 = f.woChaoFan();
                                                switch (a3){
                                                    case 0:
                                                        ReportOperationIsOpen = false;
                                                        break;
                                                    case 1:
                                                        service.guidance(sno);
                                                        break;
                                                    case 2:
                                                        service.Grade(sno);
                                                        break;
                                                }
                                            }
                                        }
                                        break;
                                }
                            }

                        } else {
                            while (menuForUser) {
                                userMenu.forAdmin();
                                int a2 = f.woChaoFan();
                                switch (a2) {
                                    case 0:
                                        menuForUser = false;
                                        break;
                                    case 1:
                                        service.searchSelection();
                                        break;
                                    case 2:
                                        service.deleteRecord();
                                        break;
                                    case 3:
                                        service.showAllUsers();
                                        break;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    loginAndRegistration.registration();
                    int a2 = f.woChaoFan();
                    switch (a2) {
                        case 0:
                            registrationIsOpen = false;
                            break;
                        case 1:
                            service.registrationForTeacher();
                            break;
                        case 2:
                            service.registrationForStudent();
                            break;
                    }
                    break;
                default:
                    System.out.println("输入错误！");
                    break;
            }
        }
    }
}
