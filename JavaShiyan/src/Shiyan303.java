import java.util.Scanner;

public class Shiyan303 {
    public static void main(String[] args) {
        int number = 10000;
        for (int i = 2;i< 10000;i++) {
            boolean a = isPrime(i);
            if(a)
                System.out.println(i);
        }
    }
    public static boolean isPrime(int number) {
        int flag = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0 && i != 1) {
                flag = 0;
                break;
            }
            else if (i+1 == number) {
                flag = 1;
            }
        }
        if (flag==0)
            return false;
        else
            return true;
    }
}
