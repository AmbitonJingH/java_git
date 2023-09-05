import java.util.Arrays;

public class leetcode520 {

    public static boolean detectCapitalUse(String word) {
        int j=0;
        if(word.length()==1)
            return true;
        if(word.charAt(0)>=65&&word.charAt(0)<=90){
            for (int i = 1; i < word.length(); i++) {
                if(word.charAt(i)>=97&&word.charAt(i)<=122){
                    j++;

                }
            }
            if(j!=0&&j<word.length()-1)
                return false;
        }else {
            for (int i = 1; i < word.length(); i++) {
                if(word.charAt(i)>=65&&word.charAt(i)<=90)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word ="USA";
        System.out.println(detectCapitalUse(word));
    }
}
