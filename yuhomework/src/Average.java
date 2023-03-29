import java.util.Scanner;

public class Average {
    public static int average(int[] array){
        int sum=0;
        for (int i=0;i<array.length;i++){
            sum = sum + array[i];
        }
        return sum/array.length;
    }
    public static double average(double[] array){
        double sum=0;
        for (int i=0;i<array.length;i++){
            sum = sum + array[i];
        }
        return sum/array.length;
    }

    public static void main(String[] args) {
        double[] a = new double [10];
        Scanner input = new Scanner(System.in);
        System.out.print("请输入10个双精度值:");
        for (int i =0;i<10;i++){
            a[i] = input.nextDouble();
        }
        System.out.println("平均值为："+average(a));
    }
}
