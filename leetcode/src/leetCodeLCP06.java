
/*
 * @author  AmbitionJingH
 * @date  2023/9/20 17:34
 * @version 1.0
 */

public class leetCodeLCP06 {
    public static int minCount(int[] coins) {
        int ans = 0;
        for (int i = 0; i < coins.length; i++) {
                ans += coins[i]/2 + coins[i]%2;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
