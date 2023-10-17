
/*
 * @author  AmbitionJingH
 * @date  2023/9/11 20:24
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode228 {
    public static void main(String[] args) {
        summaryRanges ranges = new summaryRanges();
        int[] nums = new int[]{0,1,2,4,5,7};
        List<String> list = ranges.summaryRanges(nums);
        System.out.println(list);
    }
}
class summaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(j+1== nums.length||nums[j]+1!=nums[j+1]) {
                StringBuffer sb = new StringBuffer();
                sb.append(nums[i]);
                if (i != j) {
                    sb.append("->" + nums[j]);
                }
                list.add(sb.toString());
                i = j+1;
            }
        }
        return list;
    }
}
