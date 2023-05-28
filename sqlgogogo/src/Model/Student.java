package Model;

public class Student {
    private int sno;//学号
    private String sname;//姓名
    private String major;//专业
    private String username;//用户名
    private String password;//密码
    private long numofborrow;//已借阅次数

    public Student() {

    }

    public Student(int sno, String sname, String major, String username, String password) {
        this.sno = sno;
        this.sname = sname;
        this.major = major;
        this.username = username;
        this.password = password;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    public long getNumOfBorrow() {
        return numofborrow;
    }

    public void setNumOfBorrow(long numOfBorrow) {
        this.numofborrow = numOfBorrow;
    }
    public String toString(){
        return "学生{学号："+sno+" 姓名："+sname+" 专业："+major+" 已借阅数量："+numofborrow;
    }
}
