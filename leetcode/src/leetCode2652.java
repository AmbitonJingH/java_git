
/*
 * @author  AmbitionJingH
 * @date  2023/10/17 19:02
 * @version 1.0
 */

public class leetCode2652 {
    public static int sumOfMultiples(int n) {
        int sum = 0;
        for(int i=1;i<=n;i++){
            if(i%3==0||i%5==0||i%7==0){
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfMultiples(7));
    }
}
