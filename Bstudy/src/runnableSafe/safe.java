package runnableSafe;



class SaleTicket implements Runnable{
    int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj) {//同步监视器 必须是唯一的
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售卖了：" + ticket + "号票");
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
public class safe {
    public static void main(String[] args) {
        SaleTicket s = new SaleTicket();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}

