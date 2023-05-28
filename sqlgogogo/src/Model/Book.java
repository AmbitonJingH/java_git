package Model;

public class Book {
    private int bno;
    private String bname;
    private long amount;

    public Book() {

    }

    public Book(int bno, String bname, long amount) {
        this.bno = bno;
        this.bname = bname;
        this.amount = amount;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String toString(){
        return "书籍{书籍号："+bno+" 书名："+bname+" 数量："+amount;
    }
}
