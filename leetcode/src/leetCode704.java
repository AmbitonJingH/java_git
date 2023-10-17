
/*
 * @author  AmbitionJingH
 * @date  2023/9/18 21:31
 * @version 1.0
 */

public class leetCode704 {
    public static int search(int[] nums, int target) {
        int right = nums.length-1;
        int left = 0;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 2;
        System.out.println(search(nums, target));
    }
}
