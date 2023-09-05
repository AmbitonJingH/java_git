
/*
 * @author  AmbitionJingH
 * @date  2023/9/5 12:53
 * @version 1.0
 */

public class leetCode1512 {
    public static int numIdenticalPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==nums[j]&&i<j)
                    ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1};
        System.out.println(numIdenticalPairs(arr));
    }
}
