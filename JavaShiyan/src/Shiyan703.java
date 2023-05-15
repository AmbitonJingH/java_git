import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Shiyan703 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("score.txt");

        Scanner input = new Scanner(file);
        int n = 0;
        String[] info = new String[100];
        double[] score = new double[100];
        while(input.hasNext()){
            info[n] = input.next();
            n++;
        }
        input.close();
        int temp = 0;
        for(int i=0;i<n;i++){
            if(i==2||i==3||i==4) {
                score[temp] = score[temp]+Double.parseDouble(info[i]);
            } else if((i-2)%5==0||(i-3)%5==0||(i-4)%5==0){
                score[temp] = score[temp]+Double.parseDouble(info[i]);
            }if(i>=4&&(i-4)%5==0||i==4)
                temp++;
        }
        for(int j=0;j<temp;j++){
            score[j] = score[j]/3;
        }
        File file1 = new File("newscore.txt");
        if(file1.exists()){
            System.out.println("文件已存在！");
            System.exit(1);
        }
        PrintWriter output = new PrintWriter(file1);
        output.print("姓名");
        output.print("\t学号");
        output.print("\t课程1成绩");
        output.print("\t课程2成绩");
        output.print("\t课程3成绩");
        output.print("\t平均成绩");
        output.println();
        int temp1=0;
        for (int k = 0;k<n;k++){
            output.print(info[k]);
            output.print("\t");
            if(k==4||(k-4)%5==0){
                if(temp1<6){
                    output.print(score[temp1]+"\t");
                    output.println();
                    temp1++;
                }
            }
        }
        output.close();
    }
}
