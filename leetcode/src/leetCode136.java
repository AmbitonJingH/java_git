
/*
 * @author  AmbitionJingH
 * @date  2023/10/14 9:17
 * @version 1.0
 */

public class leetCode136 {
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
        int i = singleNumber(nums);
        System.out.println(i);
    }
}
