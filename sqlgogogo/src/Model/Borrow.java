package Model;

import java.sql.Date;
import java.sql.Timestamp;

public class Borrow {
    private int uno;
    private int bno;
  //  private Date borrowTime = new java.sql.Date(System.currentTimeMillis());
    private Timestamp returnTime;
    private Timestamp borrowTime = new Timestamp(System.currentTimeMillis());

    public Borrow() {
    }

    public Borrow(int uno, int bno, Timestamp borrowTime) {
        this.uno = uno;
        this.bno = bno;
        this.borrowTime = borrowTime;
    }

    public int getSno() {
        return uno;
    }

    public void setSno(int sno) {
        this.uno = sno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public Timestamp getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Timestamp borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public String toString(){
        return "\t用户借阅信息{用户号："+uno+" 书籍号："+bno+" 借阅时间："+borrowTime+" 归还时间："+returnTime+"}\n";
    }
}
