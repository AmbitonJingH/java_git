import java.util.Scanner;

public class Shiyan403 {
    public static double getTriangleArea(double[ ][ ] points){
            if (points[0][0]==points[1][0]&&points[0][0]==points[2][0])
                return 0;
            if (points[0][1]==points[1][1]&&points[0][0]==points[2][1])
                return 0;
            if (points[2][1]/points[2][0]==points[1][1]/points[1][0]&&points[1][1]/points[1][0]==points[0][1]/points[0][0])
                return 0;
            double a,b,c,p,area;
            a = Math.abs(Math.sqrt((points[1][0]-points[0][0])*(points[1][0]-points[0][0])+(points[1][1]-points[0][1])*(points[1][1]-points[0][1])));
            b = Math.abs(Math.sqrt((points[2][0]-points[0][0])*(points[2][0]-points[0][0])+(points[2][1]-points[0][1])*(points[2][1]-points[0][1])));
            c = Math.abs(Math.sqrt((points[2][0]-points[1][0])*(points[2][0]-points[1][0])+(points[2][1]-points[1][1])*(points[2][1]-points[1][1])));
            p = (a+b+c)/2;
            area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
            return area;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] triangle = new double[3][2];
        System.out.println("请输入三角形的三个坐标");
        for (int i =0;i<3;i++)
            for (int j=0;j<2;j++){
                triangle[i][j] = input.nextDouble();
            }
        double area = getTriangleArea(triangle);
        System.out.println("三角形的面积为："+area);
    }
}
