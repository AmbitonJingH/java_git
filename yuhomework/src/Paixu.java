import java.util.Arrays;
import java.util.Scanner;

public class Paixu {
    public static double min(double[] array){
        Arrays.sort(array);
        return array[0];
    }
    public static void main(String[] args) {
        double[] a = new double [10];
        Scanner input = new Scanner(System.in);
        System.out.print("请输入10个数:");
        for (int i =0;i<10;i++){
            a[i] = input.nextDouble();
        }
        System.out.println("最小的数为："+min(a));
    }
}
