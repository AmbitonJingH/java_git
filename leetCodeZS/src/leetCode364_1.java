
/*
 * @author  AmbitionJingH
 * @date  2023/9/24 12:24
 * @version 1.0
 */

import java.util.Arrays;

public class leetCode364_1 {
    public static String maximumOddBinaryNumber(String s) {
        char[] charArray = s.toCharArray();
        char[] ans = new char[charArray.length];
        int count1=0;
        int count0=0;
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]=='1')
                count1++;
            else
                count0++;
        }
        if(count1!=1) {
            for (int i = 0; i < charArray.length - 1; i++) {
                if (count1 - 1 != 0) {
                    ans[i] = '1';
                    count1--;
                } else {
                    ans[i] = '0';
                }
            }
            ans[ans.length-1] = '1';
        }else {
            for (int i = 0; i < ans.length; i++) {
                ans[i] = '0';
                if(i== ans.length-1)
                    ans[i] = '1';
            }
        }
        String s1 = new String(ans);
        return s1;
        //System.out.println(Arrays.toString(ans));
    }

    public static void main(String[] args) {
        String s = "0101";
        String s1 = maximumOddBinaryNumber(s);
        System.out.println(s1.toString());
    }
}
