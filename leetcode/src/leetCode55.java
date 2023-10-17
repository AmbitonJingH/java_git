
/*
 * @author  AmbitionJingH
 * @date  2023/9/26 9:47
 * @version 1.0
 */

public class leetCode55 {
    public static boolean canJump(int[] nums) {
        if(nums.length==1)
            return true;
       int cover = nums[0];
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover,i+nums[i]);
            if(cover>= nums.length-1)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
