
/*
 * @author  AmbitionJingH
 * @date  2023/9/6 15:22
 * @version 1.0
 */

public class leetCode896 {
    public boolean check(int[] nums,boolean temp){
        for (int i = 0; i < nums.length-1; i++) {
            if(temp){
                if(nums[i]<nums[i+1])
                    return false;
            }else {
                if(nums[i]>nums[i+1])
                    return false;
            }
        }
        return true;
    }
    public boolean isMonotonic(int[] nums) {
        return check(nums,true)||check(nums,false);

//        if(nums[0]>=nums[1]){
//            for (int i = 1; i < nums.length-1; i++) {
//                if(nums[i]<nums[i+1])
//                    return false;
//            }
//        }else {
//            for (int i = 1; i < nums.length-1; i++) {
//                if(nums[i]>nums[i+1])
//                    return false;
//            }
//        }
//        return true;
    }

    public static void main(String[] args) {

    }
}
