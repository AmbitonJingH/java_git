
/*
 * @author  AmbitionJingH
 * @date  2023/9/11 9:36
 * @version 1.0
 */

public class leetCode205 {
    public static boolean isIsomorphic(String s, String t) {
        return check(s).equals(check(t));
    }

    public static String check(String s){
        int[] res = new int[128];
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(res[s.charAt(i)]==0){
                res[s.charAt(i)] = count++;
            }
            sb.append(res[s.charAt(i)]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "ab",t="aa";
        System.out.println(isIsomorphic(s, t));
    }
}
