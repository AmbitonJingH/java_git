import java.util.Scanner;
//import linearequation.LinearEquation;

/**
 *
 * @author Administrator
 */
public class Test {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入a的值：");
        double a = input.nextDouble();
        System.out.println("请输入b的值：");
        double b = input.nextDouble();
        System.out.println("请输入c的值：");
        double c = input.nextDouble();
        System.out.println("请输入d的值：");
        double d = input.nextDouble();
        System.out.println("请输入e的值：");
        double e = input.nextDouble();
        System.out.println("请输入f的值：");
        double f = input.nextDouble();
        LinearEquation linearequation = new LinearEquation(a,b,c,d,e,f);
        if(linearequation.isSolvable()){

            System.out.println("x="+linearequation.getX());
            System.out.println("y="+linearequation.getY());
        }else{
            System.out.println("该方程没有解");
        }

    }
}