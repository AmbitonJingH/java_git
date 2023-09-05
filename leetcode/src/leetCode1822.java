
/*
 * @author  AmbitionJingH
 * @date  2023/9/5 21:48
 * @version 1.0
 */

import java.math.BigInteger;

public class leetCode1822 {
    public static int arraySign(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0)
                return 0;
            if(nums[i]<0)
                count++;
        }
        if(count%2!=0)
            return -1;
        else
            return 1;
//        BigInteger ans = new BigInteger("1");
//        for (int i = 0; i < nums.length; i++) {
//            String temp = nums[i]+"";
//            ans.multiply(new BigInteger(temp));
//        }
//        System.out.println(ans);
//        String finalAns = ans.toString();
//        if(finalAns.contains("-"))
//            return -1;
//        else if(finalAns.length()==1&&finalAns.contains("0"))
//            return 0;
//        else
//            return 1;

//        if(ans>0)
//            return 1;
//        else if(ans<0)
//            return -1;
//        else
//            return 0;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        System.out.println(arraySign(arr));
    }
}
