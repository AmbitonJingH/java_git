package Model;

import java.sql.Date;

public class stuBorrow {
    private int sno;
    private int bno;
    private Date borrowTime = new java.sql.Date(System.currentTimeMillis());
    private Date returnTime;

    public stuBorrow() {
    }

    public stuBorrow(int sno, int bno, Date borrowTime) {
        this.sno = sno;
        this.bno = bno;
        this.borrowTime = borrowTime;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String toString(){
        return "学生借阅信息{学号："+sno+" 书籍号："+bno+" 借阅时间："+borrowTime+" 归还时间："+returnTime+"}\n";
    }
}
