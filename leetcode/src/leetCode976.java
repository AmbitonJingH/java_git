
/*
 * @author  AmbitionJingH
 * @date  2023/9/7 20:58
 * @version 1.0
 */

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Arrays;

public class leetCode976 {
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i =nums.length-1; i >=0; i--) {
            int a = nums[i];
            int b = nums[i-1];
            int c =nums[i-2];
            if(b+c>a)
                return a+b+c;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
