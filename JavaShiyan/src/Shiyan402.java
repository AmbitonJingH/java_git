import java.util.Scanner;

public class Shiyan402 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] grade = new double[10000];
        boolean a = true;
        double sum = 0;
        int i =0,upcount=0,downcount=0,jishu=0;
        while (a){
            System.out.print("(输入负数即可停止)请输入分数：");
            grade[i] = input.nextDouble();
            if (grade[i]<0){
                a = false;
            }
            i += 1;
            jishu = jishu +1;
        }
        for (i=0;i<jishu-1;i++){
            sum = sum + grade[i];
        }
        double ave = sum/(jishu-1);
        for (i=0;i<jishu-1;i++){
            if (grade[i]>=ave)
                upcount = upcount+1;
            else
                downcount = downcount+1;
        }
        System.out.println("大于等于平均分的有"+upcount+"个");
        System.out.println("小于平均分的有"+downcount+"个");
    }
}
