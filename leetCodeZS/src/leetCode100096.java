
/*
 * @author  AmbitionJingH
 * @date  2023/10/15 10:33
 * @version 1.0
 */

import java.util.Arrays;
import java.util.Map;

public class leetCode100096 {
    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] ans = new int[]{-1,-1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(Math.abs(i-j)>=indexDifference){
                    if(Math.abs(nums[i]-nums[j])>=valueDifference){
                        ans[0] = i;
                        ans[1] = j;
                        return ans;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,8,8,0,1,4};
        int[] indices = findIndices(nums, 3, 9);
        System.out.println(Arrays.toString(indices));
    }
}
