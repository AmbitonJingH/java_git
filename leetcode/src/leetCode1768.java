
/*
 * @author  AmbitionJingH
 * @date  2023/9/5 15:28
 * @version 1.0
 */

public class leetCode1768 {
    public static String mergeAlternately(String word1, String word2) {
        //StringBuffer a = new StringBuffer(word1);
        //StringBuffer b = new StringBuffer(word2);
        StringBuffer ans = new StringBuffer();
        if(word1.length()>word2.length()){
            int temp = 0;
            for (int i = 0; i <2* word2.length(); i++) {
                if(i%2==0)
                    ans.append(word1.charAt(temp));
                else
                    ans.append(word2.charAt(temp++));
                //temp++;
            }
            ans.append(word1.substring(word2.length()));
        }else{
            int temp = 0;
            for (int i = 0; i <2* word1.length(); i++) {
                if(i%2==0)
                    ans.append(word1.charAt(temp));
                else
                    ans.append(word2.charAt(temp++));
            }
            ans.append(word2.substring(word1.length()));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String word1 = "abcd", word2 = "pq";
        System.out.println(mergeAlternately(word1, word2));
    }
}
