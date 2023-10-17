
/*
 * @author  AmbitionJingH
 * @date  2023/9/19 18:04
 * @version 1.0
 */

public class leetCode74 {
    //模拟
    public static boolean searchMatrix1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    //二分
    public static boolean searchMatrix2(int[][] matrix, int target) {
    /*    for (int i = 0; i < matrix.length; i++) {
            int l = 0, r = matrix[i].length-1;
            while (l<=r){
                int m = l + (r-l)/2;
                if (matrix[i][m]<target){
                    l = m + 1;
                }else if(matrix[i][m]>target)
                    r = m - 1;
                else {
                    return true;
                }
            }
        }*/
        int l = 0,r= matrix.length-1;
        while (l<r){
            int m = (r+l+1)/2;
            if(matrix[m][0]<=target){
                l = m ;
            }else
                r = m-1;
        }

        int row = r;
        System.out.println(row);
        if(matrix[row][0] == target)
            return true;


        int l1 = 0,r1 = matrix[row].length-1;
        while (l1<r1){
            int m1 = (r1+l1+1)/2;
            if(matrix[row][m1]<target)
                l1 = m1 ;
            else if(matrix[row][m1]>target)
                r1 = m1 - 1;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1},{3}};
        int target = 0;
        System.out.println(searchMatrix2(matrix, target));
    }
}
