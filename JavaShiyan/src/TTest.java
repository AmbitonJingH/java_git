import java.util.Scanner;

public class TTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("张三");
        System.out.println(person.toString());
        Student student = new Student();
        student.setName("阿豪");
        System.out.println(student.toString());
        Employee employee = new Employee();
        employee.setName("李四");
        System.out.println(employee.toString());
        Faculty faculty = new Faculty();
        faculty.setName("阿浩");
        System.out.println(faculty.toString());
        Staff staff = new Staff();
        staff.setName("王五");
        System.out.println(staff.toString());
    }
}
