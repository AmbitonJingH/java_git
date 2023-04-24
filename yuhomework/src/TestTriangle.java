import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        System.out.print("请输入三角形三条边的值：");
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        Triangle triangle = new Triangle(a,b,c);
        System.out.print("请输入三角形的颜色:");
        String color = input.next();
        triangle.setColor(color);
        System.out.print("三角形是否被填充(false或者true):");
        boolean isfill = input.nextBoolean();
        triangle.setFilled(isfill);
        System.out.println("三角形的面积："+triangle.getArea()+"\n"+"三角形的周长："+triangle.getPerimeter()+"\n"+"颜色："+triangle.getColor()+"\n"+"是否填充："+triangle.isFilled());
    }
}
