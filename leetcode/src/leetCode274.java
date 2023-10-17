
/*
 * @author  AmbitionJingH
 * @date  2023/9/26 10:14
 * @version 1.0
 */

import java.util.Arrays;

public class leetCode274 {
    public static int hIndex(int[] citations) {
        int l=0,r = citations.length;
        while (l<r){
            int m = l+r+1>>1;
            int count = 0;
            for (int i = 0; i < citations.length; i++) {
                if(citations[i]>=m)
                    count++;
            }
            if(count>=m)
                l = m;
            else
                r = m-1;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,0,6,1,5};
        System.out.println(hIndex(arr));
    }
}
