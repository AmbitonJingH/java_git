
/*
 * @author  AmbitionJingH
 * @date  2023/10/7 21:08
 * @version 1.0
 */

public class leetCode0105 {
    public static boolean oneEditAway(String first, String second) {
//        if(second.length()-first.length()<-1)
//            return false;
//        int index = 0;
//        int len = Math.max(first.length(),second.length());
//        for (int i = 0; i < len; i++) {
//            if(first.charAt(i)!=second.charAt(i)){
//                index = i;
//            }
//        }
//        if(first.substring(index).equals(second.substring(index)))
//            return true;
//        else
//            return false;
        int n = first.length(),m = second.length();
        if(Math.abs(n-m)>1)
            return false;
        if(n>m)
            return oneEditAway(second,first);
        int i=0,j=0,res=0;
        while (i<n&&j<m&&res<=1){
            char a=first.charAt(i),b=second.charAt(j);
            if(a==b){
                i++;
                j++;
            }else {
                if(n==m){
                    i++;
                    j++;
                    res++;
                }else {
                    j++;
                    res++;
                }
            }
        }
        return res<=1;
    }

    public static void main(String[] args) {

    }
}
