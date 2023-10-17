
/*
 * @author  AmbitionJingH
 * @date  2023/9/7 18:39
 * @version 1.0
 */

public class leetCode1672 {
    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int ans = 0;
            int[] temp = accounts[i];
            for (int j = 0; j < temp.length; j++) {
                ans += temp[j];
            }
            max = Math.max(max,ans);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] accounts = new int[][]{{1,5},{7,3},{3,5}};
        System.out.println(maximumWealth(accounts));
    }
}
