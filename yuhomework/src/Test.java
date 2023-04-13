public class Test {
    public static void main(String[] args) {
        Account account1 = new Account(1122,20000);
        account1.setAnnualInterestRate(4.52500);
        account1.deposit(3000);
        System.out.println("account 1的余额为："+account1.getBalance()+"$");
        System.out.println("account 1的月利息为："+account1.getMonthlyInterest()+"$");
        System.out.println("account 1的创建时间为："+account1.getDateCreated());
    }
}
