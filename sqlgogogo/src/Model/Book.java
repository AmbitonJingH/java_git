package Model;

public class Book {
    private String bno;
    private String bname;
    private int amount;

    public Book() {

    }

    public Book(String bno, String bname, int amount) {
        this.bno = bno;
        this.bname = bname;
        this.amount = amount;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String toString(){
        return "书籍{书籍号："+bno+" 书名："+bname+" 数量："+amount;
    }
}
