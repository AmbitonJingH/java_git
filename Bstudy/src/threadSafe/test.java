package threadSafe;

class Sale extends Thread{
    static int ticket = 100;
    static Object object = new Object();//用时需要用static修饰 作为静态变量
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Sale.class) {//同步监视器必须唯一  推荐时使用 类.class
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"售卖了："+ticket+"号票");
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }
}

public class test {
    public static void main(String[] args) {
        Sale s1 = new Sale();
        Sale s2 = new Sale();
        Sale s3 = new Sale();
        s1.setName("窗口1");
        s2.setName("窗口2");
        s3.setName("窗口3");
        s1.start();
        s2.start();
        s3.start();
    }
}
