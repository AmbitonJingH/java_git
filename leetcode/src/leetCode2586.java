
/*
 * @author  AmbitionJingH
 * @date  2023/9/4 20:49
 * @version 1.0
 */

public class leetCode2586 {
    public static int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            String temp = words[i];
            if((temp.charAt(0)=='a'||temp.charAt(0)=='e'||temp.charAt(0)=='i'||temp.charAt(0)=='o'||temp.charAt(0)=='u')&&(temp.endsWith("a")||temp.endsWith("e")||temp.endsWith("i")||temp.endsWith("o")||temp.endsWith("u"))){
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] arr = new String[]{"hey","aeo","mu","ooo","artro"};
        System.out.println(vowelStrings(arr,1,4));
    }
}
