package thread;

public class exerice {
    public static void main(String[] args) {
        ouShu o = new ouShu();
        jiShu j = new jiShu();
        o.start();
        j.start();
    }
}
class ouShu extends Thread{

    @Override
    public void run() {
        for(int i=1;i<101;i++){
            if(i%2==0)
                System.out.println(Thread.currentThread().getName()+":"+i+" ");
        }
    }
}
class jiShu extends Thread{
    @Override
    public void run() {
        for(int i=1;i<101;i++){
            if(i%2!=0)
                System.out.println(Thread.currentThread().getName()+":"+i+" ");
        }
    }
}
