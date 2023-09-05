
/*
 * @author  AmbitionJingH
 * @date  2023/9/5 19:51
 * @version 1.0
 */

public class leetCode28 {
    public int strStr(String haystack, String needle) {
//        if(haystack.contains(needle))
//             return haystack.indexOf(needle);
//        else
//            return -1;
        char[] h = haystack.toCharArray(),n = needle.toCharArray();
        for (int i = 0; i < haystack.length(); i++) {
            int ans = i,b = 0;
            while (b<needle.length() && h[ans] == n[b]){
                ans++;
                b++;
            }
            if(b==needle.length())
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
