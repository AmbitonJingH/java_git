import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AGAIN {
        public static void main(String[] args) throws FileNotFoundException {

            File file = new File("score.txt");

            Scanner input = new Scanner(file);
            int n = 0;
            int temp = 0;
            String[] info = new String[100];
            double[] score = new double[100];
            while(input.hasNext()){
                info[n] = input.next();
                n++;
                info[n] = input.next();
                n++;
                info[n] = input.next();
                score[temp] = Double.parseDouble(info[n]);
                n++;
                info[n] = input.next();
                score[temp] += Double.parseDouble(info[n]);
                n++;
                info[n] = input.next();
                score[temp] += Double.parseDouble(info[n]);
                n++;
                temp++;
            }
            input.close();
            for(int i =0;i<temp;i++){
                score[i] = score[i]/3;
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
            for(int i=0;i<n;i++){
                output.print(info[i]+"\t");
                if(i==4||(i-4)%5==0){
                    output.println(score[temp1]);
                    temp1++;
                }
            }
            output.close();
        }
    }

