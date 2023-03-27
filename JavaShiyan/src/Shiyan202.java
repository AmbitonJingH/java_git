import java.util.Scanner;

public class Shiyan202 {

    public static void main(String[] args) {
        double a,b,c;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入边a的值：");
        a = input.nextDouble();
        System.out.println("请输入边b的值：");
        b = input.nextDouble();
        System.out.println("请输入边c的值：");
        c = input.nextDouble();
        if (a+b>c&&a+c>b&&b+c>a)
        {
            double girth = a + b + c;
            System.out.println("边长为"+a+"，"+b+"，"+c+"的周长为："+girth);
        }
        else System.out.println("输入无效！");
    }
}
