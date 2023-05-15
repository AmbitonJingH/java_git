import java.util.Date;

public class Employee extends Person {
    private String office;
    private double salary;
    private Date dateHired = new Date();
    public String toString(){
        String a =this.getClass()+" "+this.getName();
        return a;
    }
}
