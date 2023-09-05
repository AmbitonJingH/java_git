
/*
 * @author  AmbitionJingH
 * @date  2023/9/5 20:56
 * @version 1.0
 */

import java.util.Arrays;

public class leetCode283 {
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i <nums.length ; i++) {
                nums[i] = 0;
        }
//        int i = 0;
//        while (i<nums.length-1) {
//            if(nums[i]==0){
//                for (int j = i; j < nums.length-1; j++) {
//                    nums[j] = nums[j+1];
//                    if(j==nums.length-2)
//                        nums[j+1]=0;
//                }
//            }
//            if(nums[i]!=0){
//                i++;
//            }else {
//            }
//        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,0,0,1,1,1};
        moveZeroes(nums);
    }
}
