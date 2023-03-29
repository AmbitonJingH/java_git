import java.util.Scanner;

public class Sum {

    public static double sumMajorDiagonal(double[][] m){
        double sum = 0;
        for (int i = 0;i < m.length;i++){
                 sum = sum + m[i][i];
        }
        return sum;

    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入矩阵的维数：");
        n = input.nextInt();
        double [][] a = new double[n][n];
        for (int i = 0;i < n;i++){
            for (int j=0;j<n;j++){
                a[i][j] = input.nextDouble();
            }
        }
        System.out.println("Sum of the elements in the major diagonal is "+sumMajorDiagonal(a));
    }

}
