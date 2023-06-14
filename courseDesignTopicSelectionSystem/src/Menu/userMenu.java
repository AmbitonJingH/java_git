package Menu;

import org.junit.Test;

public class userMenu {
    public void forStudent(){
        System.out.println("=============================================");
        System.out.println("=                  1.查看题目              \t=");
        System.out.println("=                  2.选择题目              \t=");
        System.out.println("=                  3.提交课程设计报告        \t=");
        System.out.println("=                  4.查看老师评语           \t=");
        System.out.println("=                  5.查询成绩              \t=");
        System.out.println("=                  0.返回上一级             \t=");
        System.out.println("=============================================");
        System.out.println("请输入要进行的操作：");
    }

    public void forTeacher(){
        System.out.println("=============================================");
        System.out.println("=                  1.添加题目              \t=");
        System.out.println("=                  2.查看学生选题信息        \t=");
        System.out.println("=                  3.指导课程设计           \t=");
        System.out.println("=                  4.查看课程设计报告        \t=");
        System.out.println("=                  5.评分                 \t=");
        System.out.println("=                  0.返回上一级             \t=");
        System.out.println("=============================================");
        System.out.println("请输入要进行的操作：");
    }

    public void forAdmin(){
        System.out.println("=============================================");
        System.out.println("=                  1.查看所有选题信息        \t=");
        System.out.println("=                  2.删除选题记录           \t=");
        System.out.println("=                  3.所有用户              \t=");
        System.out.println("=                  0.返回上一级             \t=");
        System.out.println("=============================================");
        System.out.println("请输入要进行的操作：");
    }
}
