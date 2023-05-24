package thread;


import org.junit.Test;

public class EvenNumber{

    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        printNumber.start();
    }

}
class PrintNumber extends Thread{
    @Override
    public void run() {
        for (int i =1;i<101;i++){
            if(i%2==0)
                System.out.print(i+" ");
        }
    }


}
