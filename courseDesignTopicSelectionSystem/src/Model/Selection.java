package Model;

import java.sql.Blob;
import java.sql.Timestamp;

public class Selection {

    private int cno;
    private String sno;
    private String grade;
    private Timestamp subtime;
    private Blob report;


    public Selection() {
    }

    public Blob getReport() {
        return report;
    }

    public void setReport(Blob report) {
        this.report = report;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public float getGrade() {
        return Float.parseFloat(grade);
    }

    public void setGrade(float grade) {
        this.grade = String.valueOf(grade);
    }

    public Timestamp getSubtime() {
        return subtime;
    }

    public void setSubtime(Timestamp subtime) {
        this.subtime = subtime;
    }

    public String toString(boolean sub){
        String isSub;
        if(sub)
            isSub = "已提交";
        else
            isSub = "未提交";
        return "课程号："+cno+" 学号："+sno+" 成绩："+grade+"  课程设计报告："+isSub;
    }
}
