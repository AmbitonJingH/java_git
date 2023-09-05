
/*
 * @author  AmbitionJingH
 * @date  2023/9/5 12:47
 * @version 1.0
 */

public class leetCode1486 {
    public static int xorOperation(int n, int start) {
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = start + 2*i;
        }
        int ans= nums[0];
        for (int i = 1; i < n; i++) {
            ans = nums[i]^ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(4, 3));
    }
}
