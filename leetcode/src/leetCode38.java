
/*
 * @author  AmbitionJingH
 * @date  2023/10/7 19:32
 * @version 1.0
 */

import java.util.Arrays;

public class leetCode38 {
    public static String countAndSay(int n) {
        if(n==1)
            return "1";
        StringBuffer sb = new StringBuffer();
        String s = String.valueOf(1);
        char[] charArray = s.toCharArray();

        for (int i = 0; i < n-1; i++) {
            String check = check(charArray);
            charArray = check.toCharArray();
        }
        String s1 = String.valueOf(charArray);

        System.out.println(s1);
        //System.out.println(Arrays.toString(charArray));
        //System.out.println(check);
        return sb.toString();
    }
    public static String check(char[] charArray){
        boolean flag = false;
        char temp = charArray[0];
        StringBuffer sb = new StringBuffer();
        int count = 0,i=0,j=0,n=0;
        for (j = 0;j<charArray.length;j++) {
            count = 0;
            if(flag == true)
                n = j;
            for (i = n; i < charArray.length; i++) {
                if(charArray[i]==charArray[j]){
                    count++;
                    if (i==charArray.length-1){
                        sb.append(count);
                        sb.append(charArray[j]);
                        return sb.toString();
                    }
                }
                else{
                    sb.append(count);
                    sb.append(charArray[j]);
                    j = j+count-1;
                    flag = true;
                    break;
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int n = 30;
        String s = countAndSay(n);
        //System.out.println(s);
    }
}
