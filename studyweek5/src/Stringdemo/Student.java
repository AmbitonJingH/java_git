package Stringdemo;

public class Student {
    private String name;
    public String grade;
    public String school;
    public String age;
    public String sex;
    public String phone;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
