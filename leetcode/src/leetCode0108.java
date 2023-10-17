
/*
 * @author  AmbitionJingH
 * @date  2023/10/11 19:12
 * @version 1.0
 */

import java.util.Arrays;
import java.util.List;

public class leetCode0108 {
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length,m = matrix[0].length;
        boolean[] col = new boolean[m];
        boolean[] row = new boolean[n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==0){
                    col[j] = true;
                    row[i] = true;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if(row[i]||col[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }
}
