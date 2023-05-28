package Model;

public class Teacher {
    private int tno;
    private String tname;
    private String title;
    private String username;
    private String password;
    private int numOfBorrow = 0;

    public Teacher() {

    }

    public Teacher(int tno, String tname, String title, String username, String password) {
        this.tno = tno;
        this.tname = tname;
        this.title = title;
        this.username = username;
        this.password = password;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumOfBorrow() {
        return numOfBorrow;
    }

    public void setNumOfBorrow(int numOfBorrow) {
        this.numOfBorrow = numOfBorrow;
    }

    public String toString(){
        return "教师{教师号："+tno+" 姓名："+tname+" 职称："+title+" 已借阅数量："+numOfBorrow;
    }
}
