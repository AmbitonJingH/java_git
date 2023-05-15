import java.util.Scanner;

public class TestComparableCircle {
    public static void main(String[] args) {
        ComparableCircle circle1 = new ComparableCircle();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入圆的半径：");
        double a = input.nextDouble();
        circle1.setR(a);
        ComparableCircle circle2 = new ComparableCircle();
        System.out.println("请输入圆的半径：");
        double b = input.nextDouble();
        circle2.setR(b);
        if(circle1.compareTo(circle2)==0)
            System.out.println("两圆面积相等");
        else
            System.out.println("面积较大的圆是"+(circle1.compareTo(circle2)>0?"circle1面积为:"+circle1.getArea():"circle2面积为:"+circle2.getArea()));
    }
}
