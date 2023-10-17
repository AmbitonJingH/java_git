
/*
 * @author  AmbitionJingH
 * @date  2023/9/20 17:56
 * @version 1.0
 */

public class leetCode153 {
    public static void findMin(int[] nums) {
        int min = nums[0];
        int l = 0,r = nums.length-1;
        if(nums.length==1)
            System.out.println(0);
        if(nums[nums.length-1]>nums[0])
            System.out.println(0);
        while (l<=r){
            int m = l + (r-l)/2;
            if(nums[m]>=min)
                l = m + 1;
            else {
                //min = m;
                r = m - 1;
            }
        }
        System.out.println(l);
        System.out.println(r);
        //return nums[l];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        findMin(arr);
    }
}
