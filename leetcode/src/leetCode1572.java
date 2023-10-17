
/*
 * @author  AmbitionJingH
 * @date  2023/9/7 18:54
 * @version 1.0
 */

public class leetCode1572 {
    public static int diagonalSum(int[][] mat) {
        int ans =0;
        if(mat.length==1)
            return mat[0][0];
        else {
            for (int i = 0; i < mat.length; i++) {
                ans += mat[i][i];
            }
            for (int i = mat.length-1,j=0; i >= 0; i--) {
                ans += mat[j][i];
                j++;
            }
        }
        if(mat.length%2!=0){
            ans -= mat[mat.length/2][mat.length/2];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(diagonalSum(arr));
    }
}
