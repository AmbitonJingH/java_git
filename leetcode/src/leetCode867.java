
/*
 * @author  AmbitionJingH
 * @date  2023/9/4 21:33
 * @version 1.0
 */

import java.util.Arrays;

public class leetCode867 {
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        System.out.println(rows);
        System.out.println(cols);
        int[][] ans = new int[cols][rows];
        int k = 0;
        for (int j = 0;j<cols;j++) {
            for (int i = 0; i < rows; i++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6}};
        int[][] transpose = transpose(arr);
        for(int i=0;i<transpose.length;i++){
            int[] ans = transpose[i];
            System.out.println(Arrays.toString(ans));
        }
    }
}
