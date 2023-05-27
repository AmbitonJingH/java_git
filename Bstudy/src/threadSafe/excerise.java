package threadSafe;

class Bank{
    private double balance;

    Bank(){

    }
    public void cunqian(double money){

        if(money>0){
            balance += money;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"存钱1000块，余额："+balance);
    }
}


class Customer implements Runnable{
    Bank bank;
    Customer(Bank bank){
        this.bank = bank;
    }
    @Override
    public void run() {

        for(int i=0;i<3;i++){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Customer.class) {
                bank.cunqian(1000);
            }

        }

    }
}


public class excerise {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer c1 = new Customer(bank);
        //Customer c2 = new Customer(bank);
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c1);
        t1.setName("甲");
        t2.setName("乙");
        t1.start();
        t2.start();
    }


}
