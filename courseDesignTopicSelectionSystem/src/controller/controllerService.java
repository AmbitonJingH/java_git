package controller;

import Menu.*;
import Service.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class controllerService {
    public static void main(String[] args) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        loginAndRegistration loginAndRegistration = new loginAndRegistration();
        userMenu userMenu = new userMenu();
        service service = new service();
        Scanner input = new Scanner(System.in);
        boolean loginAndRegistrationIsOpen = true;

        while(loginAndRegistrationIsOpen){

            boolean registrationIsOpen = true;
            boolean menuForUser = true;

            loginAndRegistration.loginAndRegistration();

            int a1 = input.nextInt();
            switch (a1){
                case 0:loginAndRegistrationIsOpen = false;break;
                case 1:if(service.login()) {
                    if(service.check().equals("学生")){
                        while (menuForUser) {
                            userMenu.forStudent();
                            int a2 = input.nextInt();
                            switch (a2){
                                case 0:menuForUser = false;break;
                                case 1:break;
                                case 2:break;
                                case 3:break;
                            }
                        }
                    }else if(service.check().equals("教师")){
                        while (menuForUser) {
                            userMenu.forTeacher();
                            int a2 = input.nextInt();
                            switch (a2){
                                case 0:menuForUser = false;break;
                                case 1:service.addCourse();break;
                                case 2:break;
                                case 3:break;
                            }
                        }

                    }else{

                    }
                }
                break;
                case 2:
                        loginAndRegistration.registration();
                        int a2 = input.nextInt();
                        switch (a2){
                            case 0:registrationIsOpen = false;break;
                            case 1:service.registrationForTeacher();break;
                            case 2:service.registrationForStudent();break;
                        }
                    break;
            }
        }
    }
}
