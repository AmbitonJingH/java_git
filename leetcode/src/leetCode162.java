
/*
 * @author  AmbitionJingH
 * @date  2023/9/19 17:23
 * @version 1.0
 */

public class leetCode162 {
    public static int findPeakElement(int[] nums) {
        int l = 0,r = nums.length-1;
        int max = -1;
        while (l<=r){
            int m = l + (r-l)/2;
            if(nums[m]>nums[m+1]){
                r = m - 1;
                max = r;
            }else {
                l = m + 1;
            }

        }
        return max;
    }

    public static void main(String[] args) {


    }
}
