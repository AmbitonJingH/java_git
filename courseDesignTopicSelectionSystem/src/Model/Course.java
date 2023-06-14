package Model;

public class Course {
    private int cno;
    private int tno;
    private String cname;
    private int memberNum = 0;

    public Course() {

    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int uno) {
        this.tno = tno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public String toString(){
        return "课程号："+cno+" ";
    }
}
