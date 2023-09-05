
/*
 * @author  AmbitionJingH
 * @date  2023/9/4 19:59
 * @version 1.0
 */

public class leetcode1534 {
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if(0<=i&&i<j&&j<k&&k<arr.length){
                        if((Math.abs(arr[i]-arr[j])<=a)&&(Math.abs(arr[j]-arr[k])<=b)&&(Math.abs(arr[i]-arr[k])<=c))
                            ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3};
        int a = 0,b = 0,c = 1;
        System.out.println(countGoodTriplets(arr, a, b, c));
    }
}
