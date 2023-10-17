
/*
 * @author  AmbitionJingH
 * @date  2023/10/8 19:03
 * @version 1.0
 */

public class leetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0,i=0,j=s.length()-1,count=0,temp=0;
        StringBuilder sb = new StringBuilder();
        temp = i;
        while (i<=j){

            String str = sb.toString();
            if(!str.contains(s.substring(i,i+1))){
                sb.append(s.charAt(i++));
                count++;
            }else {
                max = Math.max(max,count);
                count=0;
                sb = new StringBuilder("");
                i = temp++;
            }
            max = Math.max(max,count);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
