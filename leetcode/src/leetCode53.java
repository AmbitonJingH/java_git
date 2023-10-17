
/*
 * @author  AmbitionJingH
 * @date  2023/10/8 20:19
 * @version 1.0
 */

public class leetCode53 {
    public static int maxSubArray(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int[] s = new int[nums.length+1];
        int min = 999999,ans = -99999;
        for (int i = 0; i < nums.length; i++) {
            s[i+1] = s[i]+nums[i];
            min = Math.min(min,s[i]);
            ans = Math.max(ans,s[i+1]-min);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }
}
