
/*
 * @author  AmbitionJingH
 * @date  2023/9/25 22:22
 * @version 1.0
 */

import java.util.Arrays;

public class leetCode189 {
    /*public static void rotate(int[] nums, int k) {
       /*  int[] ans = new int[nums.length];
         int i = 0;
         while (i!=k){
             ans[i] = nums[i+k+1];
             i++;
         }
         int count = i;
         i = 0;
         while (i!=k+1){
             ans[count++] = nums[i++];
         }
         nums = ans;
        System.out.println(Arrays.toString(nums));
        int[] ans = new int[nums.length];
        int i = 0;
        if(nums.length%2==0) {
            while (i < k) {
                ans[i] = nums[i];
                i++;
            }
            for (int j = k, t = 0; j < nums.length; j++, t++) {
                nums[t] = nums[j];
            }
            for (int j = k, t = 0; j < nums.length; j++, t++) {
                nums[j] = ans[t];
            }
        }else {
            while (i<=k){
                ans[i] = nums[i];
                i++;
            }
            for (int j = k+1, t=0; j < nums.length; j++ ,t++) {
                nums[t] = nums[j];
            }
            for (int j = k,t=0; j < nums.length; j++,t++) {
                nums[j] = ans[t];
            }
        }
        System.out.println(Arrays.toString(nums));
    }*/

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        System.out.println(2%5);
        rotate(nums,k);
    }
}
