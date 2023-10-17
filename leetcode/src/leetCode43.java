
/*
 * @author  AmbitionJingH
 * @date  2023/9/8 9:13
 * @version 1.0
 */

public class leetCode43 {
    public static String multiply(String num1, String num2) {
        long ans = 0;
        //int res = 0;
        int beishu1 = 10;
        for (int j = num2.length()-1; j >=0; j--) {
            int res = 0;
            int beishu = 10;
            for (int i = num1.length()-1; i >=0; i--) {
                int a = num2.charAt(j)-'0';
                int b = num1.charAt(i)-'0';
               long temp =  a*b;
               if(i==num1.length()-1)
                    res += temp;
               else {
                   res += temp * beishu;
                   beishu *=10;
               }
            }
            if(j==num2.length()-1)
                ans += res;
            else {
                ans = ans + (res * beishu1);
                beishu1 *= 10;
            }
        }
        return ans+"";
    }

    public static void main(String[] args) {
        String num1 = "123456789";
        String num2 = "987654321";
        System.out.println(multiply(num1, num2));
    }
}
