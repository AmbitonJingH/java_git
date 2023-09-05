
/*
 * @author  AmbitionJingH
 * @date  2023/9/4 20:15
 * @version 1.0
 */

import java.util.Arrays;

public class leetcode852 {
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while (left<right){
            int mid = left + (right-left)/2;
            if(arr[mid]<arr[mid+1]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,10,5,2};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
