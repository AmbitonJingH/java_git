
/*
 * @author  AmbitionJingH
 * @date  2023/9/7 19:55
 * @version 1.0
 */

import java.util.Arrays;

public class leetCode1491 {
    public static double average(int[] salary) {
//        int max = 0;
//        int min = salary[0];
//        for(int i:salary){
//            min = Math.min(min,i);
//        }
        double sum = 0;
        Arrays.sort(salary);
        for (int i = 1; i <salary.length-1 ; i++) {
            sum += salary[i];
        }
        return sum/(salary.length - 2);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4000,3000,1000,2000};
        System.out.println(average(arr));
    }
}
