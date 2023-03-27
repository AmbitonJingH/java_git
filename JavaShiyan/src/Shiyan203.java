import java.util.Scanner;

public class Shiyan203 {
    public static void main(String[] args) {
        int x1,x2,y1,y2;
        x1 = 0;
        y1 = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入该点的坐标想x，y");
        x2 = input.nextInt();
        y2 = input.nextInt();
        if(Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2))>10){
            System.out.println("("+x2+","+y2+")"+"is outside the circle");
        }
        else{
            System.out.println("("+x2+","+y2+")"+"is inside the circle");
        }
    }
}
