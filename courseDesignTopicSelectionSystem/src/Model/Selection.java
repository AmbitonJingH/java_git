package Model;

import java.sql.Blob;
import java.sql.Timestamp;

public class Selection {

    private int cno;
    private int sno;
    private double grade;
    private Blob report;
    private Timestamp subtime;

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

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String toString(){
        return "课程号："+cno+" 学号："+sno+" 成绩："+grade+"课程设计报告："+report;
    }
}
