import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FileWork {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Exercise.txt");
        if(file.exists()){
            System.out.println("文件已存在！");
            System.exit(1);
        }
        PrintWriter output = new PrintWriter(file);
        for(int i=0;i<100;i++){
            int a = (int)(Math.random()*1000+1);
            output.print(a);
            output.print(" ");
        }
        output.close();
        int[] nums =new int[100];
        int n=0;
        Scanner input = new Scanner(file);
        while(input.hasNext()){
            nums[n] = input.nextInt();
            n=n+1;
       }
            Arrays.sort(nums);
            for(int j=0;j<100;j++)
            System.out.println(nums[j]);
            input.close();
    }

}
