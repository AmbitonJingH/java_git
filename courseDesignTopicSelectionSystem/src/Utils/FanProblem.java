package Utils;

import java.util.Scanner;

public class FanProblem {

    public int woChaoFan(){
        int a = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            String temp = sc.next();
            try {
                a = Integer.parseInt(temp);
                break;
            } catch (NumberFormatException e) {
                System.out.print("输入错误！请重新输入：");
            }
        }
        return a;
    }
    public int woChaoFanForFloat(){
        int a = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            String temp = sc.next();
            try {
                a = Integer.parseInt(temp);
                break;
            } catch (NumberFormatException e) {
                System.out.print("输入错误！请重新输入：");
            }
        }
        return a;
    }

}
