
/*
 * @author  AmbitionJingH
 * @date  2023/10/12 19:20
 * @version 1.0
 */

public class leetCode2562 {
    public static long findTheArrayConcVal(int[] nums) {
        long res = 0;
        String ans = "";
        int i=0,j=nums.length-1;
        while(i<j){
            String t = nums[i++]+"";
            String w = nums[j--]+"";
            ans = t+w;
            res += Long.parseLong(ans);
        }
        if(nums.length%2!=0)
            res += nums[i];
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,14,13,8,12};
        long val = findTheArrayConcVal(arr);
        System.out.println(val);
    }
}
