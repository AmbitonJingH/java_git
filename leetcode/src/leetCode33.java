
/*
 * @author  AmbitionJingH
 * @date  2023/9/20 20:29
 * @version 1.0
 */

public class leetCode33 {
    public static int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        while (l<r){
            int m = l + r + 1>>1;
            if(nums[m]>=nums[0])
                l = m;
            else
                r = m - 1;
        }

        if(target>nums[0])
            l=0;
        else {
            l = l + 1;
            r = nums.length-1;
        }

        while (l<r){
            int m = l + r >>1;
            if(nums[m]>=target)
                r = m;
            else
                l = m + 1;
        }
        return nums[r]==target?r:-1;

//        int count = 0;
//        //int temp = nums[0];
//        if(nums.length==1&&nums[0] == target)
//            return 0;
//        //System.out.println(count%2);
//        if(nums[nums.length-1]>nums[0]) {
//            while (l < r) {
//                int mid = l + r + 1 >> 1;
//                if (nums[mid] <= target) l = mid;
//                else r = mid - 1;
//            }
//            return nums[r] == target ? r : -1;
//
////            while (l<r){
////                int m = l + r + 1>>1;
////                if(nums[m]<target)
////                    l = m ;
////                else if (nums[m]>target)
////                    r = m - 1;
////                else
////                    return m;
//
//        }else {
//            while (l < r) {
//                int m = l + r + 1 >> 1;
//                if (nums[m] >= target) {
//                    if (count % 2 == 0 || count == 0)
//                        l = m;
//                    else
//                        r = m - 1;
//                } else {
//                    if (count % 2 == 0 || count == 0)
//                        r = m - 1;
//                    else
//                        l = m;
//                }
//
////                else if (nums[m] < target) {
////                    if (count % 2 == 0 || count == 0)
////                        r = m - 1;
////                    else
////                        l = m;
////                } else
////                    return m;
//                count++;
//            }
//            return nums[r]==target?r:-1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        int t = 2;
        System.out.println(search(arr, t));
    }
}
