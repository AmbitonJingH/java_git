import java.util.Scanner;

public class Shiyan304 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int a = input.nextInt();
        System.out.println(a+"是回文吗？"+" "+isPalindrome(a));
        System.out.println("请输入一个字符串");
        String b = input.next();
        System.out.println(b+"是回文吗？"+" "+isPalindrome(b));
       // System.out.println(b.length());
    }
    public static boolean isPalindrome(int number){
        int a,b=0;
        a = number;
        while(a!=0){
            b = b*10+a%10;
            a/=10;
        }
        if(number==b)
            return true;
        else
            return false;
    }
    public static boolean isPalindrome(String str){
        int low = 0;
        int high = str.length()-1;
        boolean flag = true;
        while (low<high){
            if (str.charAt(low)!=str.charAt(high)){
                flag =false;
                break;
            }
            low++;
            high--;
        }
        if(flag)
            return true;
        else
            return false;
    }
}
