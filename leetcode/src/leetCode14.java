
/*
 * @author  AmbitionJingH
 * @date  2023/9/9 14:47
 * @version 1.0
 */

import java.util.Arrays;

public class leetCode14 {
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs  = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
