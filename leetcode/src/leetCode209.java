
/*
 * @author  AmbitionJingH
 * @date  2023/9/27 20:03
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class leetCode209 {
    public static int minSubArrayLen(int target, int[] nums) {
//        int min = 10000;
//        for (int i = 0; i < nums.length; i++) {
//            int ans = nums[i];
//            if(ans>=target){
//                return 1;
//            }
//            int count = 1;
//            for (int j = i+1; j < nums.length; j++) {
//                ans = ans + nums[j];
//                count++;
//                if(ans>=target){
//                    min = Math.min(min,count);
//                    break;
//                }
//            }
//        }
//        return min==10000?0:min;

        int l=0,h=0,sum=0,min = 10001;
        while (h<nums.length){
            sum += nums[h++];
            while (sum>=target){
                min = Math.min(min,h-l);
                sum -= nums[l++];
            }
        }
        return min==10001?0:min;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(6, new int[]{10,2,3}));
    }
}
