
/*
 * @author  AmbitionJingH
 * @date  2023/9/9 16:30
 * @version 1.0
 */

import java.util.HashMap;

public class leetCode290 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat shit dog"));
    }
}
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        char[] charArray = pattern.toCharArray();
        String[] strings = s.split(" ");
        if(charArray.length!=strings.length)
            return false;
        int i = 0;
        for (Character a : charArray){
            if(!map.containsKey(a)){
                if(!map.containsValue(strings[i])){
                    map.put(a,strings[i++]);
                }else
                    return false;
            }else {
                if(!map.get(a).equals(strings[i++]))
                    return false;
            }
        }
        return true;
    }

    public String check(String s){
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
}
