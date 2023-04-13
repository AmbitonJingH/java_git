import java.util.Date;
import java.util.Scanner;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

//    public void setDateCreated(Date dateCreated) {
//        this.dateCreated = dateCreated;
//    }

    public Account(){
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = getDateCreated();
    }
    public Account(int id1,double balance1){
        id = id1;
        balance = balance1;
        annualInterestRate = 0;
        dateCreated = new Date();
    }
    public double getMonthlyInterestRate(){
        double MonthlyInterestRate = (annualInterestRate/100)/12;
        return MonthlyInterestRate;
    }
    public double getMonthlyInterest(){
        double MonthlyInterest = balance * getMonthlyInterestRate();
        return MonthlyInterest;
    }
    public void withdraw(double withdraw1){
        double quqian = withdraw1;
        if (quqian>balance)
            System.out.println("余额不足！！");
        else {
            balance = balance - quqian;
            System.out.println("提取成功！");
        }
    }
    public void deposit(double deposit1){
        double cunqian = deposit1;
        if (cunqian>0){
            balance = balance + cunqian;
            System.out.println("成功存入！余额为："+balance+"$");
        }
        else {
            System.out.println("非法输入！！");
        }
    }

}
