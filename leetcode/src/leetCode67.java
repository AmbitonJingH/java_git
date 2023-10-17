
/*
 * @author  AmbitionJingH
 * @date  2023/9/8 19:27
 * @version 1.0
 */

import java.util.Arrays;
import java.util.Map;

public class leetCode67 {
    public static String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(),b.length());
        StringBuffer sbA = new StringBuffer(a).reverse();
        StringBuffer sbB = new StringBuffer(b).reverse();
        while (sbA.length()<maxLen){
            sbA.append("0");
        }
        while (sbB.length()<maxLen){
            sbB.append("0");
        }
        StringBuffer res = new StringBuffer();
        int t = 0;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < maxLen; i++) {
            num1 = sbA.charAt(i) - '0';
            num2 = sbB.charAt(i) - '0';
            if(num1+num2+t>1){
                res.append(num1+num2+t-2);
                t = 1;
            }else {
                res.append(num1+num2+t);
                t = 0;
            }
        }
        if(t==1){
            res.append("1");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }
}
