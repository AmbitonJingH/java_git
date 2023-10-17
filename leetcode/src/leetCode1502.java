
/*
 * @author  AmbitionJingH
 * @date  2023/9/6 15:20
 * @version 1.0
 */

import java.util.Arrays;

public class leetCode1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int temp = arr[1] - arr[0];
        for (int i = 1; i < arr.length-1; i++) {
            if(arr[i+1]-arr[i]!=temp)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}

