
/*
 * @author  AmbitionJingH
 * @date  2023/9/4 21:05
 * @version 1.0
 */

public class leetCode1422 {
    public static int maxScore(String s) {
        int left = 0,right = 0,ans = 0;
        if(s.charAt(0)=='0')
            left++;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)=='1')
                right++;
        }
        ans = left + right;
        for (int i = 1; i < s.length()-1; i++) {
            if(s.charAt(i)=='0')
                left++;
            else
                right--;
            ans = Math.max(ans,right+left);
        }
        return ans;

//        int ans = 0;
//        int max = 0;
//        if(!s.contains("0")||!s.contains("1"))
//            return s.length()-1;
//        for (int i = 0; i < s.length()-1; i++) {
//            String one = s.substring(0,i+1);
//            System.out.println(one);
//            String two = s.substring(i+1);
//            System.out.println(two);
//            for (int j = 0; j < one.length(); j++) {
//                if(one.charAt(j)=='0'){
//                    ans++;
//                }
//            }
//            for (int j = 0; j < two.length(); j++) {
//                if(two.charAt(j)=='1'){
//                    ans++;
//                }
//            }
//            if (ans > max){
//                max = ans;
//            }
//            ans = 0;
//        }
//        return max;
    }
    public static void main(String[] args) {
        String s = "011101";
        System.out.println(maxScore(s));
    }
}
