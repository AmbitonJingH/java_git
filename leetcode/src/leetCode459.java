
/*
 * @author  AmbitionJingH
 * @date  2023/9/5 20:13
 * @version 1.0
 */

public class leetCode459 {
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).indexOf(s,1)!=s.length();
    }

    public static void main(String[] args) {

    }
}
