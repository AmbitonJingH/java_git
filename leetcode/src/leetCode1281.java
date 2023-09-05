
/*
 * @author  AmbitionJingH
 * @date  2023/9/4 22:27
 * @version 1.0
 */

public class leetCode1281 {
    public static int subtractProductAndSum(int n) {
        int mul = 1;
        int add = 0;
        while (n!=0){
            int temp = n%10;
            n /=10;
            mul *= temp;
            add += temp;
        }
        return mul-add;
    }

    public static void main(String[] args) {
        int n = 234;
        System.out.println(subtractProductAndSum(n));
    }
}
