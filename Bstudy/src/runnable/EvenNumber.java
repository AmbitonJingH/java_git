package runnable;

public class EvenNumber {
    public static void main(String[] args) {
        PrintNummber p1 = new PrintNummber();
        printNumber p = new printNumber();
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p);
        t1.start();
        t2.start();
    }
}
class PrintNummber implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<=100;i++){
            if(i%2==0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
class printNumber implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<=100;i++){
            if(i%2!=0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
