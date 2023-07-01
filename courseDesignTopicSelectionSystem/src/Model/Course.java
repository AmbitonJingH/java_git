package Model;

public class Course {
    private int cno;
    private String tno;
    private String cname;
    private int member = 0;

    public Course() {

    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String uno) {
        this.tno = tno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getMemberNum() {
        return member;
    }

    public void setMemberNum(int memberNum) {
        this.member = memberNum;
    }

    public String toString(){
        return "课程号："+cno+" ";
    }
}
