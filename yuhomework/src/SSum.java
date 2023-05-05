import java.util.InputMismatchException;
import java.util.Scanner;

public class SSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean a = true;
        do{
            try{
                System.out.print("请输入两个整数：");
                int num1 = input.nextInt();
                int num2 = input.nextInt();
                int sum = num1+num2;
                System.out.println("两数之和为："+sum);
                a = false;
            }
            catch (InputMismatchException ex){
                System.out.println("请重新输入。（需要输入整数！）");
                input.nextLine();
            }
        }while(a);
    }
}
