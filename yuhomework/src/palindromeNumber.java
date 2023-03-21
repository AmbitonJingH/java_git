import java.util.Scanner;

public class palindromeNumber {
    public static void main(String[] args) {
        System.out.print("请输入一个三位整数:");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int num1 = a % 10;
        int num2 = a / 100;
        if (num1==num2)
            System.out.println(a + "是回文");
        else
            System.out.println(a + "不是回文");

    }
}
