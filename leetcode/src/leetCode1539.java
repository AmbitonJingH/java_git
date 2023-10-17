
/*
 * @author  AmbitionJingH
 * @date  2023/9/18 21:53
 * @version 1.0
 */

public class leetCode1539 {
    public static int findKthPositive(int[] arr, int k) {
        if(arr[0]>k)
            return k;
        int ans = 0,left = 0,right = arr.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid] - mid -1 >=k){
                ans = mid;
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return ans+k;
    }

    public static void main(String[] args) {

    }
}
