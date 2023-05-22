package Model;

import java.sql.Date;

public class teaBorrow {
    private String tno;
    private String bno;
    private Date borrowTime;
    private Date returnTime;

    public teaBorrow(String tno, String bno, Date borrowTime) {
        this.tno = tno;
        this.bno = bno;
        this.borrowTime = borrowTime;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
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
        return "教师借阅信息{教师号："+tno+" 书籍号："+bno+" 借阅时间："+borrowTime+" 归还时间："+returnTime;
    }

}
