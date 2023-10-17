
/*
 * @author  AmbitionJingH
 * @date  2023/10/7 20:45
 * @version 1.0
 */

public class leetCode0103URL {
    public static String replaceSpaces(String S, int length) {
        S = S.substring(0,length).replaceAll(" ","%20");
        return S;
    }

    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        String s1 = replaceSpaces(s, 13);
        System.out.println(s1);
    }
}
