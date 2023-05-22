package Model;

import java.sql.Date;

public class stuBorrow {
    private String sno;
    private String bno;
    private Date borrowTime;
    private Date returnTime;

    public stuBorrow(String sno, String bno, Date borrowTime) {
        this.sno = sno;
        this.bno = bno;
        this.borrowTime = borrowTime;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
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
        return "学生借阅信息{学号："+sno+" 书籍号："+bno+" 借阅时间："+borrowTime+" 归还时间："+returnTime;
    }
}
