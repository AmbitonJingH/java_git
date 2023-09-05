
/*
 * @author  AmbitionJingH
 * @date  2023/9/4 21:16
 * @version 1.0
 */

import java.util.Arrays;

public class leetCode1470 {
    public static int[] shuffle(int[] nums, int n) {
        int a = 0,b = 0;
        int[] newArray = new int[2*n];
        int[] temp = Arrays.copyOfRange(nums,n,2*n);
        for (int i = 0; i < newArray.length; i++) {
            if(i%2==0){
                newArray[i] = nums[a];
                a++;
            }else {
                newArray[i] = temp[b];
                b++;
            }

        }
        //System.out.println(temp);
        return newArray;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,1,3,4,7};
        int[] shuffle = shuffle(arr, 3);
        System.out.println(Arrays.toString(shuffle));
    }
}
