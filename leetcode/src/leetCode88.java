
/*
 * @author  AmbitionJingH
 * @date  2023/9/9 10:59
 * @version 1.0
 */

import java.util.Arrays;

public class leetCode88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
        merge(new int[]{1},1,new int[]{},0);
        merge(new int[]{0},0,new int[]{1},1);
    }
}
